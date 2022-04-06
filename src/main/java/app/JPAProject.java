/*
 * Licensed under the Academic Free License (AFL 3.0).
 *     http://opensource.org/licenses/AFL-3.0
 *
 *  This code is distributed to CSULB students in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, other than educational.
 *
 *  2018 Alvaro Monge <alvaro.monge@csulb.edu>
 *
 */

package app;

// Import all of the entity classes that we have written for this application.
//import csulb.cecs323.model.*;

import model.Books;
import model.Publishers;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * A simple application to demonstrate how to persist an object in JPA.
 * <p>
 * This is for demonstration and educational purposes only.
 * </p>
 * <p>
 *     Originally provided by Dr. Alvaro Monge of CSULB, and subsequently modified by Dave Brown.
 * </p>
 */
public class JPAProject {
   /**
    * You will likely need the entityManager in a great many functions throughout your application.
    * Rather than make this a global variable, we will make it an instance variable within the CarClub
    * class, and create an instance of CarClub in the main.
    */
   private EntityManager entityManager;

   /**
    * The Logger can easily be configured to log to a file, rather than, or in addition to, the console.
    * We use it because it is easy to control how much or how little logging gets done without having to
    * go through the application and comment out/uncomment code and run the risk of introducing a bug.
    * Here also, we want to make sure that the one Logger instance is readily available throughout the
    * application, without resorting to creating a global variable.
    */
   private static final Logger LOGGER = Logger.getLogger(JPAProject.class.getName());

   /**
    * The constructor for the CarClub class.  All that it does is stash the provided EntityManager
    * for use later in the application.
    * @param manager    The EntityManager that we will use.
    */
   public JPAProject(EntityManager manager) {
      this.entityManager = manager;
   }

   public static void main(String[] args) {
      LOGGER.setLevel(Level.OFF);
      LOGGER.fine("Creating EntityManagerFactory and EntityManager");
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAProject");
      EntityManager manager = factory.createEntityManager();
      // Create an instance of CarClub and store our new EntityManager as an instance variable.
      JPAProject jpaProject = new JPAProject(manager);
      Scanner in = new Scanner(System.in);

      // Any changes to the database need to be done within a transaction.
      // See: https://en.wikibooks.org/wiki/Java_Persistence/Transactions
      LOGGER.fine("Begin of Transaction");
      EntityTransaction tx = manager.getTransaction();

      tx.begin();

      //to add objects
      List <Publishers> publishers = new ArrayList<>();
      List <Books> books = new ArrayList<Books>();

      System.out.println("Enter the number for Tasks:");
      System.out.println("1. Add new objects");
      System.out.println("2. List all the information about a specific Object");
      System.out.println("3. Delete a Book");
      System.out.println("4. Update a Book");
      System.out.println("5. List the primary key");
      System.out.println("6. Done");
      int userInput = in.nextInt();

      while(userInput < 1 || userInput > 6){
         System.out.println("Enter a valid number for the which Task");
         userInput = in.nextInt();
      }

      while (userInput != 6) {
         if (userInput == 1) {
            System.out.println("Add which Object: ");
            System.out.println("1. Add a new Authoring Entity instance");
            System.out.println("2. Add a new Publisher");
            System.out.println("3. Add a new Book");
            int objectInput = in.nextInt();
            while (objectInput < 1 || objectInput > 3) {
               System.out.println("Enter a valid number for the which Object");
               objectInput = in.nextInt();
            }
            if (objectInput == 1) {
               System.out.println("Which Authoring Entity instance:");
               System.out.println("1. Writing Group");
               System.out.println("2. Individual Author");
               System.out.println("3. Ad Hoc Team");
               int authoringEntityInput = in.nextInt();
               while (authoringEntityInput < 1 || authoringEntityInput > 3) {
                  System.out.println("Enter a valid number for the which Authoring Entity instance");
                  authoringEntityInput = in.nextInt();
               }
               if (authoringEntityInput == 1) {
                  System.out.println("writing group");
                  /*public Writing_Group (String email, String authoring_entity_type, String name, String head_writer, int year_formed){
                       this.setEmail(email);
                       this.setAuthoring_Entity_Type(authoring_entity_type);
                       this.setName(name);
                       this.setHead_Writer(head_writer);
                       this.setYear_Formed(year_formed);
                   }*/

               }
               if (authoringEntityInput == 2) {
                  System.out.println("Individual Author");
               }
               if (authoringEntityInput == 3) {
                  System.out.println("Ad Hoc Team");
               }
            }
            if (objectInput == 2) {
               System.out.println("Add a new Publisher");
               System.out.println("Enter Name: ");
               String nameInput= in.nextLine();
               String Input= in.nextLine();
               // ^ idk why but the nameInput won't take in the user input,
               // but if I did this, then it does take an Input
               //System.out.println(Input);
               System.out.println("Enter Email: ");
               String emailInput= in.nextLine();
               System.out.println("Enter Phone: ");
               String phoneInput= in.nextLine();
               publishers.add(new Publishers(Input, emailInput, phoneInput));
               System.out.println(publishers);
            }
            if (objectInput == 3) {
               System.out.println("Add a new Book");
            }
         }
         if (userInput == 2) {
            //List all the information about a specific Object
            System.out.println("Which Object: ");
            System.out.println("1. Publisher");
            System.out.println("2. Book");
            System.out.println("3. Writing Group");
            int infoObjectInput = in.nextInt();
            while (infoObjectInput < 1 || infoObjectInput > 3) {
               System.out.println("Enter a valid number for the which Object");
               infoObjectInput = in.nextInt();
            }
            if (infoObjectInput == 1) {
               System.out.println("Publisher");
               for (int i = 0; i < publishers.size(); i++) {
                  System.out.println( (i+1) + ": "
                          + publishers.get(i).getName());
               }
               int pubObjectInput = in.nextInt();
               while (pubObjectInput < 1 || pubObjectInput > publishers.size()){
                  System.out.println("Enter a valid number for the which Object");
                  pubObjectInput = in.nextInt();
               }
               for (int i = 0; i < publishers.size(); i++) {
                  if((i + 1) == pubObjectInput){
                     System.out.println( (i+1) + ": "
                             + publishers.get(i).getName() + " "
                             + publishers.get(i).getEmail() + " "
                             + publishers.get(i).getPhone());
                  }
               }
            }
            if (infoObjectInput == 2) {
               System.out.println("Book");
            }
            if (infoObjectInput == 3) {
               System.out.println("Writing Group");
            }
         }
         if (userInput == 3) {
            System.out.println("Delete a Book");
            // Should remove the book in the first row
            books.remove(0);
         }
         if (userInput == 4) {
            System.out.println("Update a Book");
         }
         if (userInput == 5) {
            //List the primary key of all the rows of:
            //a. Publishers
            //b. Books (show the title as well as the ISBN)
            //c. Authoring entities – and supply the type of authoring entity for
            //each one as well.
            System.out.println("Primary Keys");
         }
         printMenu();
         userInput = in.nextInt();
      }

      jpaProject.createEntity(publishers);

      // Commit the changes so that the new data persists and is visible to other users.
      tx.commit();
      LOGGER.fine("End of Transaction");

   } // End of the main method

   /**
    * Create and persist a list of objects to the database.
    * @param entities   The list of entities to persist.  These can be any object that has been
    *                   properly annotated in JPA and marked as "persistable."  I specifically
    *                   used a Java generic so that I did not have to write this over and over.
    */
   public <E> void createEntity(List <E> entities) {
      for (E next : entities) {
         LOGGER.info("Persisting: " + next);
         // Use the CarClub entityManager instance variable to get our EntityManager.
         this.entityManager.persist(next);
      }

      // The auto generated ID (if present) is not passed in to the constructor since JPA will
      // generate a value.  So the previous for loop will not show a value for the ID.  But
      // now that the Entity has been persisted, JPA has generated the ID and filled that in.
      for (E next : entities) {
         LOGGER.info("Persisted object after flush (non-null id): " + next);
      }
   } // End of createEntity member method

   /**
    * Prints out the starter menu
    */

   public static void printMenu(){
      System.out.println("1. Add new objects");
      System.out.println("2. List all the information about a specific Object");
      System.out.println("3. Delete a Book");
      System.out.println("4. Update a Book");
      System.out.println("5. List the primary key");
      System.out.println("6. Done");
   }
} // End of CarClub class
