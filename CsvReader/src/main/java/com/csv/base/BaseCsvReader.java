package com.csv.base;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csv.annotation.ExcelField;
import com.csv.exception.DException;
import com.csvreader.CsvReader;

public class BaseCsvReader {

	private static final BaseCsvReader instance = new BaseCsvReader();

	private BaseCsvReader() {

	}

	public static BaseCsvReader getInstance() {
		return instance;
	}

	public <T> List<T> readSheet(Class<T> clazz, String filePath) {
		CsvReader reader = null;
		List<T> list = new ArrayList<T>();
		try {
			reader = new CsvReader(new FileInputStream(filePath), Charset.forName("gbk"));
			reader.readRecord();
			if (!"%%".equals(reader.get(0))) {
				reader.close();
				reader = new CsvReader(new FileInputStream(filePath), Charset.forName("gbk"));
			}
			reader.readHeaders();
			reader.readRecord();

			while (reader.readRecord()) {
				if (reader.get(0).startsWith("#")) {
					continue;
				}
				T t = clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					ExcelField excelField = null;
					if ((excelField = field.getDeclaredAnnotation(ExcelField.class)) != null) {
						String columnName = excelField.name();
						String columnValue = reader.get(columnName);
						Class<?> fieldType = field.getType();
						String fieldTypeName = fieldType.getName();
						Object fieldValue = convertColumnValue2FieldValue(fieldTypeName, columnValue);
						setter(t, field.getName(), fieldValue, fieldType);
					}
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return list;
	}

	public static Object convertColumnValue2FieldValue(String fieldTypeName, String columnValue) throws DException {
		switch (fieldTypeName) {
		case "byte":
			return Byte.parseByte(columnValue);
		case "short":
			return Short.parseShort(columnValue);
		case "int":
			return Integer.parseInt(columnValue);
		case "long":
			return Long.parseLong(columnValue);
		case "float":
			return Float.parseFloat(columnValue);
		case "double":
			return Double.parseDouble(columnValue);
		case "char":
			return columnValue.charAt(0);
		case "boolean":
			if ("1".equals(columnValue)) {
				return true;
			} else if ("0".equals(columnValue)) {
				return false;
			}
		case "java.lang.String":
			return columnValue;
		}
		throw new DException("需要添加新的类型", fieldTypeName);
	}

	public static <T> void setter(T obj, String att, Object value, Class<?> type) {
		try {
			Method met = obj.getClass().getMethod("set" + initStr(att), type);
			met.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void getter(T obj, String att, Class<?> type) {
		Method met = null;
		try {
			if (type.getName().equals("boolean")) {
				met = obj.getClass().getMethod("is" + initStr(att));
			} else {
				met = obj.getClass().getMethod("get" + initStr(att));
			}
			System.out.println(met.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String initStr(String old) {
		String str = old.substring(0, 1).toUpperCase() + old.substring(1);
		return str;
	}
}
