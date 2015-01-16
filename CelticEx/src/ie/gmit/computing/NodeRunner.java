package ie.gmit.computing;

import java.util.HashMap;
import java.util.Map;

public class NodeRunner {
	
	/**
	 * Class in which a Node Tree is populated for user.
	 */
	
	public static Map<String,Node> maps=new HashMap<String,Node>();
	
	
	public NodeRunner(){
		super();
		
     Node root=new Node("start",null);
     maps.put("hard", root);
		
		Node hard=new Node("hard",root);
        root.add(hard);
	    maps.put("hard", hard);

	    
		Node flexible=new Node("flexible",root);
        root.add(flexible);
        maps.put("flexible", flexible);
        
        Node solid=new Node("solid",root);
	    root.add(solid);
	    maps.put("solid", solid);
	    
	    Node squashed=new Node("can be squashed",solid);
	    //squashed.setImage(new ImageIcon("me.png"));
	    solid.add(squashed);
	    maps.put("squashed", squashed);
	    
	    Node Filamentous=new Node("Filamentous",flexible);
	    flexible.add(Filamentous);
	    maps.put("Filamentous", Filamentous);
	    
	    Node large2D=new Node("Large2D SurfaceArea",flexible);
	    flexible.add(large2D);
	    maps.put("Large2D SurfaceArea",large2D);
	    
	    Node Smooth=new Node("Smooth edges",hard);
	    hard.add(Smooth);
	    maps.put("Smooth edges",Smooth);
	    
	    Node irregular=new Node("irregular edges",hard);
	    hard.add(irregular);
	    maps.put("irregular edges",irregular);
	    
	    Node styrene=new Node("styrene",squashed);
	    squashed.add(styrene);
	    maps.put("styrene",styrene);
	    
	    Node fibre=new Node("fibre",Filamentous);
	    Filamentous.add(fibre);
	    maps.put("fibre",fibre);
	    
	    Node film=new Node("film",large2D);
	    large2D.add(film);
	    maps.put("film",film);
	    
	    Node fragment=new Node("fragment",irregular);
	    irregular.add(fragment);
	    maps.put("fragment",fragment);
	    
	    Node edges=new Node("edges",fragment);
	    fragment.add(edges);
	    maps.put("edges",edges);
	    
	    Node all=new Node("All Argular",edges);
	    edges.add(all);
	    maps.put("all",all);
	    
	    Node most=new Node("Most Argular",edges);
	    edges.add(most);
	    maps.put("most",most);
	    
	    Node mostrounded=new Node("Most rounded",edges);
	    edges.add(mostrounded);
	    maps.put("mostrounded",mostrounded);
	    
	    Node allrounded=new Node("All rounded",edges);
	    edges.add(allrounded);
	    maps.put("allrounded",allrounded);
	    
	    Node resin=new Node("resin",Smooth);
	    Smooth.add(resin);
	    maps.put("resin",resin);
	    
	    Node cylindrical=new Node("cylindrical",resin);
	    resin.add(cylindrical);
	    maps.put("cylindrical",cylindrical);
	    
	    Node rounded=new Node("rounded",resin);
	    resin.add(rounded);
	    maps.put("rounded",rounded);
	    
	    Node longg=new Node("long",cylindrical);
	    cylindrical.add(longg);
	    maps.put("long",longg);
	    
	   
	    Node flat=new Node("flat",cylindrical);
	    cylindrical.add(flat);
	    maps.put("flat",flat);
	    
	    Node oval=new Node("oval",rounded);
	    rounded.add(oval);
	    maps.put("oval",oval);
	    
	    Node sphere=new Node("sphere",rounded);
	    rounded.add(sphere);
	    maps.put("sphere",sphere);
	}
}
