import java.util.*;

// Simple JSON Object
class JSONObject {
    private Map<String, Object> map = new LinkedHashMap<>();
    
    public JSONObject() {}
    
    public JSONObject(String jsonString) {
        parseObject(jsonString.trim());
    }
    
    private void parseObject(String json) {
        if (!json.startsWith("{") || !json.endsWith("}")) {
            throw new RuntimeException("Invalid JSON object");
        }
        
        json = json.substring(1, json.length() - 1).trim();
        if (json.isEmpty()) return;
        
        int depth = 0;
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        boolean inKey = true;
        boolean inString = false;
        
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            
            if (c == '"' && (i == 0 || json.charAt(i-1) != '\\')) {
                inString = !inString;
                if (inKey) key.append(c);
                else value.append(c);
                continue;
            }
            
            if (!inString) {
                if (c == '{' || c == '[') depth++;
                if (c == '}' || c == ']') depth--;
                
                if (depth == 0 && c == ':' && inKey) {
                    inKey = false;
                    continue;
                }
                
                if (depth == 0 && c == ',') {
                    addKeyValue(key.toString().trim(), value.toString().trim());
                    key = new StringBuilder();
                    value = new StringBuilder();
                    inKey = true;
                    continue;
                }
            }
            
            if (inKey) key.append(c);
            else value.append(c);
        }
        
        if (key.length() > 0) {
            addKeyValue(key.toString().trim(), value.toString().trim());
        }
    }
    
    private void addKeyValue(String keyStr, String valueStr) {
        String cleanKey = keyStr.replace("\"", "").trim();
        Object parsedValue = parseValue(valueStr);
        map.put(cleanKey, parsedValue);
    }
    
    private Object parseValue(String valueStr) {
        valueStr = valueStr.trim();
        
        if (valueStr.equals("null")) return null;
        if (valueStr.equals("true")) return true;
        if (valueStr.equals("false")) return false;
        
        if (valueStr.startsWith("\"") && valueStr.endsWith("\"")) {
            return valueStr.substring(1, valueStr.length() - 1);
        }
        
        if (valueStr.startsWith("{")) {
            return new JSONObject(valueStr);
        }
        
        if (valueStr.startsWith("[")) {
            return new JSONArray(valueStr);
        }
        
        try {
            if (valueStr.contains(".")) {
                return Double.parseDouble(valueStr);
            } else {
                return Integer.parseInt(valueStr);
            }
        } catch (NumberFormatException e) {
            return valueStr;
        }
    }
    
    public JSONObject put(String key, Object value) {
        map.put(key, value);
        return this;
    }
    
    public Object get(String key) {
        return map.get(key);
    }
    
    public String getString(String key) {
        Object value = map.get(key);
        return value == null ? null : value.toString();
    }
    
    public int getInt(String key) {
        Object value = map.get(key);
        if (value instanceof Integer) return (Integer) value;
        if (value instanceof String) return Integer.parseInt((String) value);
        return 0;
    }
    
    public boolean getBoolean(String key) {
        Object value = map.get(key);
        if (value instanceof Boolean) return (Boolean) value;
        return false;
    }
    
    public JSONObject getJSONObject(String key) {
        Object value = map.get(key);
        return value instanceof JSONObject ? (JSONObject) value : null;
    }
    
    public JSONArray getJSONArray(String key) {
        Object value = map.get(key);
        return value instanceof JSONArray ? (JSONArray) value : null;
    }
    
    public boolean isNull(String key) {
        return map.get(key) == null;
    }
    
    public boolean has(String key) {
        return map.containsKey(key);
    }
    
    public Set<String> keySet() {
        return map.keySet();
    }
    
    public String toString() {
        return toString(0);
    }
    
    public String toString(int indent) {
        if (map.isEmpty()) return "{}";
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        if (indent > 0) sb.append("\n");
        
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            
            if (indent > 0) {
                sb.append("  ".repeat(indent));
            }
            
            sb.append("\"").append(entry.getKey()).append("\":");
            if (indent > 0) sb.append(" ");
            
            Object value = entry.getValue();
            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else if (value instanceof JSONObject) {
                sb.append(((JSONObject) value).toString(indent > 0 ? indent + 1 : 0));
            } else if (value instanceof JSONArray) {
                sb.append(((JSONArray) value).toString(indent > 0 ? indent + 1 : 0));
            } else if (value == null) {
                sb.append("null");
            } else {
                sb.append(value);
            }
            
            if (it.hasNext()) sb.append(",");
            if (indent > 0) sb.append("\n");
        }
        
        if (indent > 0 && indent > 1) {
            sb.append("  ".repeat(indent - 1));
        }
        sb.append("}");
        
        return sb.toString();
    }
    
    public static final Object NULL = new Object() {
        @Override
        public String toString() { return "null"; }
    };
}

// Simple JSON Array
class JSONArray {
    private List<Object> list = new ArrayList<>();
    
    public JSONArray() {}
    
    public JSONArray(String jsonString) {
        parseArray(jsonString.trim());
    }
    
    private void parseArray(String json) {
        if (!json.startsWith("[") || !json.endsWith("]")) {
            throw new RuntimeException("Invalid JSON array");
        }
        
        json = json.substring(1, json.length() - 1).trim();
        if (json.isEmpty()) return;
        
        int depth = 0;
        StringBuilder value = new StringBuilder();
        boolean inString = false;
        
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            
            if (c == '"' && (i == 0 || json.charAt(i-1) != '\\')) {
                inString = !inString;
                value.append(c);
                continue;
            }
            
            if (!inString) {
                if (c == '{' || c == '[') depth++;
                if (c == '}' || c == ']') depth--;
                
                if (depth == 0 && c == ',') {
                    addValue(value.toString().trim());
                    value = new StringBuilder();
                    continue;
                }
            }
            
            value.append(c);
        }
        
        if (value.length() > 0) {
            addValue(value.toString().trim());
        }
    }
    
    private void addValue(String valueStr) {
        Object parsedValue = parseValue(valueStr);
        list.add(parsedValue);
    }
    
    private Object parseValue(String valueStr) {
        valueStr = valueStr.trim();
        
        if (valueStr.equals("null")) return null;
        if (valueStr.equals("true")) return true;
        if (valueStr.equals("false")) return false;
        
        if (valueStr.startsWith("\"") && valueStr.endsWith("\"")) {
            return valueStr.substring(1, valueStr.length() - 1);
        }
        
        if (valueStr.startsWith("{")) {
            return new JSONObject(valueStr);
        }
        
        if (valueStr.startsWith("[")) {
            return new JSONArray(valueStr);
        }
        
        try {
            if (valueStr.contains(".")) {
                return Double.parseDouble(valueStr);
            } else {
                return Integer.parseInt(valueStr);
            }
        } catch (NumberFormatException e) {
            return valueStr;
        }
    }
    
    public JSONArray put(Object value) {
        list.add(value);
        return this;
    }
    
    public Object get(int index) {
        return list.get(index);
    }
    
    public String getString(int index) {
        Object value = list.get(index);
        return value == null ? null : value.toString();
    }
    
    public int getInt(int index) {
        Object value = list.get(index);
        if (value instanceof Integer) return (Integer) value;
        if (value instanceof String) return Integer.parseInt((String) value);
        return 0;
    }
    
    public JSONObject getJSONObject(int index) {
        Object value = list.get(index);
        return value instanceof JSONObject ? (JSONObject) value : null;
    }
    
    public JSONArray getJSONArray(int index) {
        Object value = list.get(index);
        return value instanceof JSONArray ? (JSONArray) value : null;
    }
    
    public int length() {
        return list.size();
    }
    
    public void remove(int index) {
        list.remove(index);
    }
    
    public String toString() {
        return toString(0);
    }
    
    public String toString(int indent) {
        if (list.isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        if (indent > 0) sb.append("\n");
        
        for (int i = 0; i < list.size(); i++) {
            Object value = list.get(i);
            
            if (indent > 0) {
                sb.append("  ".repeat(indent));
            }
            
            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else if (value instanceof JSONObject) {
                sb.append(((JSONObject) value).toString(indent > 0 ? indent + 1 : 0));
            } else if (value instanceof JSONArray) {
                sb.append(((JSONArray) value).toString(indent > 0 ? indent + 1 : 0));
            } else if (value == null) {
                sb.append("null");
            } else {
                sb.append(value);
            }
            
            if (i < list.size() - 1) sb.append(",");
            if (indent > 0) sb.append("\n");
        }
        
        if (indent > 0 && indent > 1) {
            sb.append("  ".repeat(indent - 1));
        }
        sb.append("]");
        
        return sb.toString();
    }
}