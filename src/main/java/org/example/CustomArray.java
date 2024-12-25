package org.example;

import java.util.Comparator;


public  class CustomArray {

    // Binary search for byte[]

    public static int binarySearch( byte[] a,  byte key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( byte[] a,  int fromIndex,  int toIndex,  byte key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for char[]

    public static int binarySearch( char[] a,  char key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( char[] a,  int fromIndex,  int toIndex,  char key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for  double[]

    public static int binarySearch( double[] a,  double key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( double[] a,  int fromIndex,  int toIndex,  double key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for  float[]

    public static int binarySearch( float[] a,  float key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( float[] a,  int fromIndex,  int toIndex,  float key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for int[]

    public static int binarySearch( int[] a,  int key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( int[] a,  int fromIndex,  int toIndex,  int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for long[]

    public static int binarySearch( long[] a,  long key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( long[] a,  int fromIndex,  int toIndex,  long key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for short[]

    public static int binarySearch( short[] a,  short key) {
        return binarySearchHelper(a, 0, a.length, key);
    }

    public static int binarySearch( short[] a,  int fromIndex,  int toIndex,  short key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key);
    }

    // Binary search for generic T[] with Comparator

    public static <T> int binarySearch( T[] a,  T key,  Comparator c) {
        return binarySearchHelper(a, 0, a.length, key, c);
    }

    public static <T> int binarySearch( T[] a,  int fromIndex,  int toIndex,  T key,  Comparator c) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearchHelper(a, fromIndex, toIndex, key, c);
    }

    //for byte[]

    private static int binarySearchHelper(byte[] a, int fromIndex, int toIndex,
                                     byte key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; //нашли 
        }
        return -(low + 1);  //не нашли key
    }



    //for char[]

    private static int binarySearchHelper(char[] a, int fromIndex, int toIndex,
                                     char key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            char midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; //нашли 
        }
        return -(low + 1);  //не нашли key
    }

    //for double[]

    private static int binarySearchHelper(double[] a, int fromIndex, int toIndex,
                                     double key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = a[mid];

            if (midVal < key)
                low = mid + 1;  
            else if (midVal > key)
                high = mid - 1;
            else {
                long midBits = Double.doubleToLongBits(midVal);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits)     
                    return mid;             // нашли
                else if (midBits < keyBits) 
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -(low + 1);  // не нашли key
    }

    //for float[]

    private static int binarySearchHelper(float[] a, int fromIndex, int toIndex,
                                     float key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            float midVal = a[mid];

            if (midVal < key)
                low = mid + 1;  
            else if (midVal > key)
                high = mid - 1;
            else {
                int midBits = Float.floatToIntBits(midVal);
                int keyBits = Float.floatToIntBits(key);
                if (midBits == keyBits)     
                    return mid;             // нашли
                else if (midBits < keyBits) 
                    low = mid + 1;
                else                        
                    high = mid - 1;
            }
        }
        return -(low + 1);  // не нашли key
    }

    //for int[]

    private static int binarySearchHelper(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // нашли
        }
        return -(low + 1);  // не нашли key
    }

    //for long[]

    private static int binarySearchHelper(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // нашли
        }
        return -(low + 1);  // не нашли key
    }

    //for short[]

    private static int binarySearchHelper(short[] a, int fromIndex, int toIndex,
                                     short key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // нашли
        }
        return -(low + 1);  // не нашли key
    }

    //for generic T[] with Comparator

    private static <T> int binarySearchHelper(T[] a, int fromIndex, int toIndex,
                                         T key, Comparator<? super T> c) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = a[mid];
            int cmp = c.compare(midVal, key);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // нашли
        }
        return -(low + 1);  // не нашли key
    }


    static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }
}