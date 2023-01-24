package tietorakenteet;

// https://www.geeksforgeeks.org/doubly-circular-linked-list-set-1-introduction-and-insertion/
// https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/

// and middle
import java.util.Scanner;

class DList {
 
    static Node start;
 
    // Structure of a Node
    static class Node {
        int data;
        Node next;
        Node prev;
        
    static void Find(int value) {
    	Node temp = start;
    	int luku2 = value;
    	if (temp == null) {
    		System.out.print(luku2);
        	System.out.print(" ei löydy listasta, koska lista on tyhjä \n");
        	return;
    	}
    	do {
    		if(luku2 == (int)(temp.data)) {
            	System.out.print(luku2);
            	System.out.print(" löytyy listasta \n");
            	return;
            }
            
            temp = temp.next; 
        }
    	 while (temp != start);  
        	System.out.print(luku2);
        	System.out.print(" ei löydy listasta \n");
        	return;
    	
    }

    static void insertEnd(int value)
    {
   	Node temp = start;
   	//sortList();
   	if (start == null) {
        Node new_node = new Node();
        new_node.data = value;
        new_node.next = new_node.prev = new_node;
        start = new_node;
        return;
    }

    	do {
     		if(value == (temp.data)) {
             	System.out.print(value);
             	System.out.print(" löytyy listasta \n");
             	return;
             }
             
             temp = temp.next; 
         }
     	 while (temp != start);
    	Node new_node = new Node();
        new_node.data = value;
    	do {
    		 if (value < temp.data ) {
    			 	new_node.next = temp;
    			 	new_node.prev = temp.prev;
    			 	temp.prev.next = new_node;
    		    	temp.prev = new_node;
    		    	if (value < start.data) {
    		    		start = new_node;
    		    	}
    	        	return;
    		 }
             
             temp = temp.next; 
         }
     	 while (temp != start);
    	new_node.next = start;
    	new_node.prev = start.prev;
    	start.prev.next = new_node;
    	start.prev = new_node;
    	return;
    }
    
    public static void printNodes() {  
        Node current = start;  
        if(start == null) {  
            System.out.println("Lista on tyhjä");  
            return;  
        }  
        System.out.println("Lista järjestettynä: ");  
        
        do{    
            System.out.print(current.data + ", ");  
            current = current.next;  
        }  while(current != start) ;
        
    }  
    
    public static void printNodes2() {  
        Node current = start;  
        if(start == null) {  
            System.out.println("Lista on tyhjä");  
            return;  
        }  
        System.out.println("Lista käänteisesti järjestettynä: ");  
        
        do{  
        	current = current.prev; 
            System.out.print(current.data + ", ");  
        }  while(current != start) ;
        
    } 

    static void Delete(int key) {
    	Node temp = start;
    	//sortList();
    	 if (temp == null) {
    		 System.out.print("listan alkio tyhjä");
    		 return;
    	 }
    	 
        if ( temp.data == key) {
        	if (temp.next == temp) {
        		start = null;
        		return;
        	}
            start = temp.next;
            temp.prev.next = start;
            start.prev = temp.prev;
            return;
        }
        while (temp.next != start) {
        	temp = temp.next; 
    		if(key == (temp.data)) {
            	temp.next.prev = temp.prev;
            	temp.prev.next = temp.next;
            	return;
            }
        }
        System.out.print("Alkiota ei löytynyt listasta");
    }
       
    public static void push(int temp)
    {
        Node new_node = new Node();
        new_node.next = start;
        start = new_node;
    }

    public static void showmenu() {
		Scanner scanner = new Scanner(System.in);
		int answer = -1;
		
	do {
			System.out.println("Valitse: 1. Lisää kokonaisluku; 2. Hae kokonaisluku"+
	" 3. Poista kokonaisluku; 4. Tulosta lista; 5. Tulosta käänteinen lista 0. Lopetus");
		answer = scanner.nextInt();
		 switch(answer)
	        {
	            case 1:
	                System.out.println("Anna kokonaisluku");
	                int luku1 = scanner.nextInt();
	                insertEnd(luku1);
	                break;
	            case 2:
	                System.out.println("Anna kokonaisluku");
	                scanner.nextLine();
	                int luku2 = scanner.nextInt();
	                Find(luku2);
	                break;
	            case 3:
	                System.out.println("Anna Poistettava kokonaisluku");
	                int luku4 = scanner.nextInt();
	                Delete(luku4);
	                break;
	            case 4:
	            	printNodes();
	                break;
	            case 5:
	            	printNodes2();
	                break;
	            default:
	                break;
	        }
	} while (answer !=0); 
	System.out.println("Tulit tien päähän");
	  scanner.close(); 
	}
    

    public static void main(String[] args)
    {        /* Start with the empty list */
        Node start = null;
        showmenu();
    }
    }
    }