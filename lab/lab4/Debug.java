class Debug {
     // set DEBUG to false to compile out debug code
     public static final boolean DEBUG = false;

     public static void debugPrintln(Object o) {
          if (DEBUG) System.out.println(o);
     }
}

