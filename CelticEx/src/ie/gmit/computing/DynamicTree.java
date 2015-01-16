package ie.gmit.computing;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DynamicTree extends Activity implements View.OnClickListener{
	private int n = 3;
	private static final int ID = 0;
	Button root;
	Node way = null;
	Node currNode = new Node();
	
	LinearLayout container = null;
	NodeRunner str = new NodeRunner();

	Node currentNode = new Node("Decision Support");
//	Node hard = new Node("hard");
//	Node flexible = new Node("hard");
//	Node solid = new Node("solid");
//	Node squashed = new Node("squashed");
//	Node Filamentous = new Node("Filamentous");
//	Node large2D = new Node("large2D");
//	Node Smooth = new Node("Smooth");
//	Node irregular = new Node("irregular");
//	Node styrene = new Node("styrene");
//	Node fibre = new Node("fibre");
//	Node film = new Node("film");
//	Node fragment = new Node("fragment");
//	Node edges = new Node("edges");
//	Node all = new Node("all");
//	Node most = new Node("most");
//	Node mostrounded = new Node("mostrounded");
//	Node allrounded = new Node("allrounded");
//	Node resin = new Node("resin");
//	Node allrounded = new Node("allrounded");
//	Node resin = new Node("resin");
//	
	
	//change back to 20
	
	/**
	 * This should create buttons on the fly from the Tree 
	 * and should refresh the page each time.
	 */
		@Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_tree_q);
	      
	    container = (LinearLayout)findViewById(R.id.dynamicBtns);
	  	root = new Button(getApplicationContext());
	  	root.setText("Start");
	  	root.setId(ID);
	  	root.setTextSize(52);
	  	root.setOnClickListener(this);
	  	container.addView(root);
	  	
	  	//Button addB = (Button) findViewById(R.id.addBtn);
		//Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);

	      
	     /* for (int i = 0; i < n; i++) {
		        Button button = new Button(this);
		        button.setText("Button :"+i);
		        button.setId(i);
		        final int buttonID = button.getId();

		        LinearLayout layout = (LinearLayout) findViewById(R.id.dyn_layout);
		        layout.addView(button);
		        	        	        
		        button.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		                Toast.makeText(DynamicTree.this, "Button clicked index = " + buttonID, Toast.LENGTH_SHORT).show();
		            }
		        });
		    }
	      
	   }
		
		public void refreshScreen(Node node){
			 setContentView(R.layout.activity_tree_q);
			 LinearLayout buttons = (LinearLayout) findViewById(R.id.dynamicBtns);

			Button backBtn = (Button) findViewById(R.id.back);
			 backBtn.setOnClickListener(new View.OnClickListener() {
			 public void onClick(View view){
			 if(currentNode.getParent() != null){
			 refreshScreen(currentNode.getParent());
			 }
			 }
			 });

			currentNode = node;
			 TextView title = (TextView) findViewById(R.id.current);
			 title.setText(currentNode.getName());

			if(currentNode.children() != null){
			 Node[] children = currentNode.children();
			 for (int i = 0; i < children.length; i++) {
			 Button button = new Button(this);
			 button.setText(children[i].toString());
			 button.setId(i);
			 final int buttonID = button.getId();

			buttons.addView(button);

			button.setOnClickListener(new View.OnClickListener() {
			 public void onClick(View view) {
			 refreshScreen(currentNode.children()[buttonID]);
			 }
			 });
			 }
			 }*/
		 }

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button btn = (Button)findViewById(v.getId());//check for any buttons there
			btn.setVisibility(View.GONE);
			
			String name = (String)btn.getText();
			
			Node parentNode = NodeRunner.maps.get(name);
			Node[] children = parentNode.children();
			
			for(int i = 0; i < children.length; i++){
				Node node = children[i];
				String childdname = node.getName();
				Button button = new Button(getApplicationContext());
				button.setText(childdname);
				button.setOnClickListener(this);
				container.addView(button);
			}

		}

	}

