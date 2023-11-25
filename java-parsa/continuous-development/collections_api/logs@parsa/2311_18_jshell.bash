|  Welcome to JShell -- Version 17.0.8
|  For an introduction type: /help intro

jshell> Map<Integer, String> map = new HashMap<>();
   ...> map.put(1, "nabo");
   ...> map.put(2, "are");
   ...> map.put(3, "uni");
   ...> map.forEach((key, value) -> System.out.println(key + " :: " + value));
map ==> {}
$2 ==> null
$3 ==> null
$4 ==> null
1 :: nabo
2 :: are
3 :: uni

jshell>
