/*
 * Copyright (c) 2015-2016, NewHeight Co.,Ltd.
 * All rights reserved.
 * $Id: GetterUtil.java 1491667 2015-11-12 03:50:31Z mayuanchao $
 */
package com.buy.core.common.util;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * GetterUtil 公共方法 处理 字符串转数据，日期等
 * @author: mayuanchao@yhd.com
 * @version $Revision: 1491667 $ $Date: 2015-11-12 11:50:31 +0800 (Thu, 12 Nov 2015) $
  */
public final class GetterUtil {
    private static Log logger = LogFactory.getLog(GetterUtil.class);
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final boolean[] DEFAULT_BOOLEAN_VALUES = new boolean[0];
    private static final double DEFAULT_DOUBLE = 0.0;
    private static final double[] DEFAULT_DOUBLE_VALUES = new double[0];
    private static final float DEFAULT_FLOAT = 0;
    private static final float[] DEFAULT_FLOAT_VALUES = new float[0];
    private static final int DEFAULT_INTEGER = 0;
    private static final int[] DEFAULT_INTEGER_VALUES = new int[0];
    private static final long DEFAULT_LONG = 0;
    private static final Long[] DEFAULT_LONG_VALUES = new Long[0];
    private static final short DEFAULT_SHORT = 0;
    private static final short[] DEFAULT_SHORT_VALUES = new short[0];
    private static final String DEFAULT_STRING = "";
    private static String[] BOOLEANS = { "true", "t", "y", "on", "1" };

    public static boolean getBoolean(String value) {
        return getBoolean(value, DEFAULT_BOOLEAN);
    }

    public static boolean getBoolean(String value, boolean defaultValue) {
        return get(value, defaultValue);
    }

    public static boolean[] getBooleanValues(String[] values) {
        return getBooleanValues(values, DEFAULT_BOOLEAN_VALUES);
    }

    public static boolean[] getBooleanValues(String[] values, boolean[] defaultValue) {
        if (values == null) {
            return defaultValue;
        }

        boolean[] booleanValues = new boolean[values.length];

        for (int i = 0; i < values.length; i++) {
            booleanValues[i] = getBoolean(values[i]);
        }

        return booleanValues;
    }

    public static Date getDate(String value, DateFormat df) {
        return getDate(value, df, new Date());
    }

    public static Date getDate(String value, DateFormat df, Date defaultValue) {
        return get(value, df, defaultValue);
    }

    public static double getDouble(String value) {
        return getDouble(value, DEFAULT_DOUBLE);
    }

    public static double getDouble(String value, double defaultValue) {
        return get(value, defaultValue);
    }

    public static double[] getDoubleValues(String[] values) {
        return getDoubleValues(values, DEFAULT_DOUBLE_VALUES);
    }

    public static double[] getDoubleValues(String[] values, double[] defaultValue) {
        if (values == null) {
            return defaultValue;
        }

        double[] doubleValues = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            doubleValues[i] = getDouble(values[i]);
        }

        return doubleValues;
    }

    public static float getFloat(String value) {
        return getFloat(value, DEFAULT_FLOAT);
    }

    public static float getFloat(String value, float defaultValue) {
        return get(value, defaultValue);
    }

    public static float[] getFloatValues(String[] values) {
        return getFloatValues(values, DEFAULT_FLOAT_VALUES);
    }

    public static float[] getFloatValues(String[] values, float[] defaultValue) {
        if (values == null) {
            return defaultValue;
        }

        float[] floatValues = new float[values.length];

        for (int i = 0; i < values.length; i++) {
            floatValues[i] = getFloat(values[i]);
        }

        return floatValues;
    }

    public static int getInteger(String value) {
        return getInteger(value, DEFAULT_INTEGER);
    }

    public static int getInteger(Integer value, int defaultValue) {
        if ((value == null)) {
            value = defaultValue;
        }

        return value;
    }

    public static int getInteger(Integer value) {
        return getInteger(value, DEFAULT_INTEGER);
    }

    public static int getInteger(String value, int defaultValue) {
        return get(value, defaultValue);
    }

    public static Integer getInteger(String value, Integer defaultValue) {
        return get(value, defaultValue);
    }

    public static int[] getIntegerValues(String[] values) {
        return getIntegerValues(values, DEFAULT_INTEGER_VALUES);
    }

    public static int[] getIntegerValues(String[] values, int[] defaultValue) {
        if (values == null) {
            return defaultValue;
        }

        int[] intValues = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            intValues[i] = getInteger(values[i]);
        }

        return intValues;
    }

    public static long getLong(String value) {
        return getLong(value, DEFAULT_LONG);
    }

    public static long getLong(Long value) {
        return getLong(value, DEFAULT_LONG);
    }

    public static long getLong(Long value, long defaultValue) {
        if (value == null) {
            return defaultValue;
        }

        return value.longValue();
    }

    public static long getLong(String value, long defaultValue) {
        return get(value, defaultValue);
    }

    public static Long getLong(String value, Long defaultValue) {
        return get(value, defaultValue);
    }

    public static Long[] getLongValues(String[] values) {
        return getLongValues(values, DEFAULT_LONG_VALUES);
    }

    public static Long[] getLongValues(String[] values, Long[] defaultValue) {
        if (values == null) {
            return defaultValue;
        }

        Long[] longValues = new Long[values.length];

        for (int i = 0; i < values.length; i++) {
            longValues[i] = getLong(values[i]);
        }

        return longValues;
    }

    public static short getShort(String value) {
        return getShort(value, DEFAULT_SHORT);
    }

    public static short getShort(String value, short defaultValue) {
        return get(value, defaultValue);
    }

    public static short[] getShortValues(String[] values) {
        return getShortValues(values, DEFAULT_SHORT_VALUES);
    }

    public static short[] getShortValues(String[] values, short[] defaultValue) {
        if (values == null) {
            return defaultValue;
        }

        short[] shortValues = new short[values.length];

        for (int i = 0; i < values.length; i++) {
            shortValues[i] = getShort(values[i]);
        }

        return shortValues;
    }

    public static String getString(String value) {
        return getString(value, DEFAULT_STRING);
    }

    public static String getString(String value, String defaultValue) {
        return get(value, defaultValue);
    }

    public static boolean get(String value, boolean defaultValue) {
        if (value != null) {
            value = value.trim();

            if (value.equalsIgnoreCase(BOOLEANS[0]) || value.equalsIgnoreCase(BOOLEANS[1]) || value.equalsIgnoreCase(BOOLEANS[2])
                    || value.equalsIgnoreCase(BOOLEANS[3]) || value.equalsIgnoreCase(BOOLEANS[4])
               ) {
                return true;
            } else {
                return false;
            }
        }

        return defaultValue;
    }

    public static Date get(String value, DateFormat df, Date defaultValue) {
        if (StringUtils.isEmpty(getString(value))) {
            return defaultValue;
        }

        try {
            Date date = df.parse(value.trim());

            if (date != null) {
                return date;
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return defaultValue;
    }

    public static double get(String value, double defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isBlank(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Double.parseDouble(value);
    }

    public static float get(String value, float defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isBlank(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Float.parseFloat(value);
    }

    public static int get(String value, int defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Integer.parseInt(value);
    }

    public static Integer get(String value, Integer defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Integer.parseInt(value);
    }

    public static long get(String value, long defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Long.parseLong(value);
    }

    public static Long get(String value, Long defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Long.parseLong(value);
    }

    public static short get(String value, short defaultValue) {
        if (StringUtils.isNotEmpty(value)) {
            value = _trim(value);
        }

        if (StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return defaultValue;
        }

        return Short.parseShort(value);
    }

    public static String get(String value, String defaultValue) {
        if (!StringUtils.isBlank(value)) {
            value = value.trim();

            if ("null".equals(value)) {
                value = defaultValue;
            }

            return value;
        }

        return defaultValue;
    }

    public static String getString(Map<String, String> datamap, String key) {
        return getString(datamap, key, DEFAULT_STRING);
    }

    public static String getString(Map<String, String> datamap, String key, String defaultValue) {
        return get(datamap, key, defaultValue);
    }

    public static int getInteger(Map<String, String> datamap, String key) {
        return getInteger(datamap, key, DEFAULT_INTEGER);
    }

    public static int getInteger(Map<String, String> datamap, String key, int defaultValue) {
        return get(datamap, key, defaultValue);
    }

    public static String get(Map<String, String> datamap, String key, String defaultValue) {
        String value = datamap.get(key);

        return get(value, defaultValue);
    }

    public static int get(Map<String, String> datamap, String key, int defaultValue) {
        String value = datamap.get(key);

        return get(value, defaultValue);
    }

    public static boolean get(Map<String, String> datamap, String key, boolean defaultValue) {
        String value = datamap.get(key);

        if (value != null) {
            value = value.trim();

            if (value.equalsIgnoreCase(BOOLEANS[0]) || value.equalsIgnoreCase(BOOLEANS[1]) || value.equalsIgnoreCase(BOOLEANS[2])
                    || value.equalsIgnoreCase(BOOLEANS[3]) || value.equalsIgnoreCase(BOOLEANS[4])
               ) {
                return true;
            } else {
                return false;
            }
        }

        return defaultValue;
    }

    public static boolean getBoolean(Map<String, String> datamap, String key) {
        return get(datamap, key, DEFAULT_BOOLEAN);
    }

    public static boolean getBoolean(Map<String, String> datamap, String key, boolean defaultValue) {
        return get(datamap, key, defaultValue);
    }

    private static String _trim(String value) {
        if (value != null) {
            value = value.trim();

            return value.replaceAll(" ", "");
        }

        return value;
    }

    public static boolean isChineseChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            String bb = str.substring(i, i + 1);
            boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);

            if (cc) {
                return true;
            }
        }

        return false;
    }

    public static <K, V> Map<K, V> getFixDatamap(Map<K, V> datamap) {
        return (datamap == null) ? new HashMap<K, V>() : datamap;
    }

    public static <T> List<T> getFixDatalist(List<T> dataList) {
        return (dataList == null) ? new ArrayList<T>() : dataList;
    }

    public static <T> Set<T> getFixDataset(Set<T> dataSet) {
        return (dataSet == null) ? new HashSet<T>() : dataSet;
    }

    public static Integer[] getSplit2IntegerArray(String codes, String splitChar) {
        if (StringUtils.isBlank(codes)) {
            return null;
        }

        String[] stringArr = StringUtils.split(codes, splitChar);
        Integer[] intList = new Integer[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            intList[i] = getInteger(stringArr[i]);
        }

        return intList;
    }

    public static Integer[] getSplit2IntegerArray(String codes) {
        return getSplit2IntegerArray(codes, ",");
    }

    public static List<String> getSplit2List(String codes, String splitChar) {
        if (StringUtils.isBlank(codes)) {
            return new ArrayList<String>(0);
        }

        return Arrays.asList(StringUtils.split(codes, splitChar));
    }

    public static List<String> getSplit2List(String codes) {
        return getSplit2List(codes, ",");
    }

    public static List<Long> getSplit2Long(String codes, String splitChar) {
        if (StringUtils.isBlank(codes)) {
            return new ArrayList<Long>(0);
        }

        String[] stringArr = StringUtils.split(codes, splitChar);

        return getSplit2Long(stringArr);
    }

    public static List<Long> getSplit2Long(String[] stringArray) {
        List<Long> longList = new ArrayList<Long>();

        if (ArrayUtils.isNotEmpty(stringArray)) {
            for (int i = 0; i < stringArray.length; i++) {
                longList.add(getLong(stringArray[i]));
            }
        }

        return longList;
    }

    public static List<Long> getSplit2Long(String codes) {
        return getSplit2Long(codes, ",");
    }

    public static List<Integer> getSplit2Integer(String codes, String splitChar) {
        if (StringUtils.isBlank(codes)) {
            return new ArrayList<Integer>(0);
        }

        String[] stringArr = StringUtils.split(codes, splitChar);
        List<Integer> intList = new ArrayList<Integer>(stringArr.length);

        for (int i = 0; i < stringArr.length; i++) {
            intList.add(getInteger(stringArr[i]));
        }

        return intList;
    }

    public static String[] getSplitStr(String codes, String splitChar) {
        if (StringUtils.isBlank(codes)) {
            return new String[0];
        }

        String[] stringArr = StringUtils.split(codes, splitChar);

        return stringArr;
    }

    public static String[] getSplitStr(String codes) {
        return getSplitStr(codes, ",");
    }

    public static List<Integer> getSplit2Integer(String codes) {
        return getSplit2Integer(codes, ",");
    }

    public static <T> T[] concat(T[] first, T[] second, Class<T> type) {
        T[] result = newArray(type, first.length + second.length);
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);

        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<T> type, int length) {
        return (T[]) Array.newInstance(type, length);
    }

    public static <T> List<T> splitSubList(List<T> targetList, int start, int end) {
        int asize = targetList.size();

        if ((start > end) || (start > asize)) {
            return null;
        }

        if (end > asize) {
            end = asize;
        }

        return targetList.subList(start, end);
    }

    public static Map<String, String> split2Map(String codes) {
        Map<String, String> result = new HashMap<String, String>();
        List<String> list = getSplit2List(codes, ",");

        for (String str : list) {
            String[] stringArr = StringUtils.split(str, "-");

            if (ArrayUtils.isNotEmpty(stringArr)) {
                if (stringArr.length >= 2) {
                    result.put(stringArr[0], stringArr[1]);
                } else {
                    result.put(stringArr[0], null);
                }
            }
        }

        return result;
    }

    public static <T> List<List<T>> getSplitList(List<T> baseList, int reqSplitSize) {
        if (CollectionUtils.isEmpty(baseList)) {
            return null;
        }

        int totalSize = baseList.size();
        int loopCount = Math.min(totalSize, reqSplitSize);
        int loop = totalSize % loopCount;

        if (loop == 0) {
            loop = totalSize / loopCount;
        } else {
            loop = (totalSize / loopCount) + 1;
        }

        List<List<T>> resultList = new ArrayList<List<T>>();

        for (int i = 0; i < loop; i++) {
            int startIndex = i * loopCount;
            int endIndex = Math.min(startIndex + loopCount, totalSize);
            resultList.add(baseList.subList(startIndex, endIndex));
        }

        return resultList;
    }

    public static String convertListToString(List<Long> ltos, String signStr) {
        if (ltos == null) {
            return null;
        }

        String str = null;
        StringBuilder sb = new StringBuilder();

        for (Long stols : ltos) {
            sb.append(signStr).append(stols);
        }

        if (sb.length() > 0) {
            str = sb.substring(1);
        }

        return str;
    }
}
