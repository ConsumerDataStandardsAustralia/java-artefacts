/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client;

import au.org.consumerdatastandards.client.model.MetaPaginated;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.GsonFireBuilder;
import okio.ByteString;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class JSON {
    private Gson gson;
    private boolean isLenientOnJson = false;
    final private DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    final private SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    final private OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    final private LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();

    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder();
        return fireBuilder.createGsonBuilder();
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if (null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    private static Class getClassByDiscriminator(Map classByDiscriminatorValue, String discriminatorValue) {
        Class clazz = (Class) classByDiscriminatorValue.get(discriminatorValue.toUpperCase(Locale.ROOT));
        if (null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    public JSON(boolean validating) {

        GsonBuilder builder = createGson()
                .registerTypeAdapter(Date.class, dateTypeAdapter)
                .registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter)
                .registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter)
                .registerTypeAdapter(LocalDate.class, localDateTypeAdapter)
                .registerTypeAdapter(byte[].class, new ByteArrayAdapter());
        if (validating) {
            builder.registerTypeAdapterFactory(new ValidatorAdapterFactory());
        }
        gson = builder.create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     * @return JSON
     */
    public JSON setGson(Gson gson) {
        this.gson = gson;
        return this;
    }

    public JSON setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
        return this;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String body, Type returnType) {
        try {
            return deserialize(new StringReader(body), returnType);
        } catch (JsonParseException e) {
            if (returnType.equals(String.class)) {
                return (T) body;
            } else {
                throw (e);
            }
        }
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The Reader of a JSON stream
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    public <T> T deserialize(Reader body, Type returnType) {
        if (isLenientOnJson) {
            JsonReader jsonReader = new JsonReader(body);
            // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
            jsonReader.setLenient(true);
            return gson.fromJson(jsonReader, returnType);
        } else {
            return gson.fromJson(body, returnType);
        }
    }

    /**
     * Gson TypeAdapter for Byte Array type
     */
    public static class ByteArrayAdapter extends TypeAdapter<byte[]> {

        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(ByteString.of(value).base64());
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String bytesAsBase64 = in.nextString();
            ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
            return byteString.toByteArray();
        }
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String date = in.nextString();
            if (date.endsWith("+0000")) {
                date = date.substring(0, date.length() - 5) + "Z";
            }
            return OffsetDateTime.parse(date, formatter);
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String date = in.nextString();
            return LocalDate.parse(date, formatter);
        }
    }

    public JSON setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {}

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String date = in.nextString();
            try {
                if (dateFormat != null) {
                    return new java.sql.Date(dateFormat.parse(date).getTime());
                }
                return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
            } catch (ParseException e) {
                throw new JsonParseException(e);
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {}

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String date = in.nextString();
                try {
                    if (dateFormat != null) {
                        return dateFormat.parse(date);
                    }
                    return ISO8601Utils.parse(date, new ParsePosition(0));
                } catch (ParseException e) {
                    throw new JsonParseException(e);
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    public JSON setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
        return this;
    }
}

class ValidatorAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        // If the type adapter is a reflective type adapter, we want to modify the implementation using reflection. The
        // trick is to replace the Map object used to lookup the property name. Instead of returning null if the
        // property is not found, we throw a Json exception to terminate the deserialization.
        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);

        // Check if the type adapter is a reflective, cause this solution only work for reflection.
        // We also don't need to augment the adapter for the "rubber" type MetaPaginated and its descendants
        if (delegate instanceof ReflectiveTypeAdapterFactory.Adapter && type.getType() instanceof Class &&
                !MetaPaginated.class.isAssignableFrom((Class)type.getType())) {
            try {
                // Get reference to the existing boundFields.
                Field f = delegate.getClass().getDeclaredField("boundFields");
                f.setAccessible(true);
                Map boundFields = (Map) f.get(delegate);

                // Then replace it with our implementation throwing exception if the value is null.
                boundFields = new LinkedHashMap(boundFields) {
                    @Override
                    public Object get(Object key) {
                        Object value = super.get(key);
                        if (value == null) {
                            throw new JsonParseException("Unexpected property: " + key);
                        }
                        return value;
                    }
                };
                // Finally, push our custom map back using reflection.
                f.set(delegate, boundFields);
            } catch (Exception e) {
                // Should never happen if the implementation doesn't change.
                throw new IllegalStateException(e);
            }
        }
        return delegate;
    }
}
