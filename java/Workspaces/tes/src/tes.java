import java.util.ArrayList;
import java.util.List;

class tes{

//	public static void main(String[] args) { 
//		List<String> list = new ArrayList<String>(); 
//		list.add("a"); 
//		list.add("b"); 
//		list.add("c"); 
//		list.add("d"); list.add("e");
//		String childs = "" ; 
//		List<String> result = new ArrayList<String>(); 
//		getSubList(list, 0, childs, result);  
//		System.out.println("真子集 " + result.size() + " 个"); 
//	    for (String results : result) { 
//	    	System.out.println(results); 
//	    } 
//	}
//
//	private static void getSubList(List<String> resourses, 
//			int nonius, String childs, List<String> results) {
//		System.out.println(resourses.size());
//		System.out.println(childs.length());
//		System.out.println("===========");
//		for(int i = nonius; i < resourses.size(); i++ ){
//			if (childs.length() < resourses.size()-1) {
//				childs = resourses.get(i);
//				System.out.println("childs:"+childs);
//				results.add(childs);
//				System.out.println("results:"+results);
//				getSubList(resourses, i + 1, childs, results);
//				childs.substring(1, childs.length()-1);
//			}
//		}
//		
//	}
	
	public static void main(String[] args) { 
		List<String> list = new ArrayList<String>(); 
		list.add("a"); 
		list.add("b"); 
		list.add("c"); 
		list.add("d"); 
		list.add("e");
		ArrayList<String> child = new ArrayList<String>(); 
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>(); 
		getSubList(list, 0, child, result);  
		System.out.println("真子集 " + result.size() + " 个"); 
		for (List<String> results : result) { 
			System.out.println(results); 
		} 
	}
	
	private static void getSubList(List<String> resourses, 
			int nonius, ArrayList<String> childs, List<ArrayList<String>> results) {
		System.out.println(resourses.size());
		System.out.println(childs.size());
		System.out.println("===========");
		for(int i = nonius; i < resourses.size(); i++ ){
			if (childs.size() < resourses.size()-1) {
				childs.add(resourses.get(i));
				System.out.println("childs:"+childs);
				results.add(new ArrayList<String>(childs));
				System.out.println("results:"+results);
				getSubList(resourses, i + 1, childs, results);
				childs.remove(childs.size()-1);
			}
		}
		
	}
} 