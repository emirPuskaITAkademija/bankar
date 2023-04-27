# HibernateMvn
Hibernate ORM without JPA specification( XML based mapping)



# ZADATAK 1:
## Hibernate 
		 
### DB
		 sakila -> shows
		 
### App
		 HibernateMvn -> Show
		 
		 
### Koraci
		 1. depenendencies -> hibernate-core
		 2. depenendencies -> mysql driver
		 3. res -> hibernate.cfg.xml   DIJALEKT
		 4. shows -> Show 
			4.1  Show   Show.hbm.xml 
			    hibernate.cfg.xml   <mapping resource="entity/Show.hbm.xml" class="ba.firma.entity.Show"/>
			4.2  Show -> anotacija JPA
		 5. SessionFactory  -> Session 
		    HibernateUtil -> SINGLETON SessionFactory 
			
			Session -> ostvarivati interakciju s bazom
			
		
		Optimistic LOCK -> 
		
		app1      -> shows
		
		    red 1 -> version 1
		
		
		app2      -> shows 
		 
			
			red 2 -> version 2
			
			
			
			
			CRUD operacije bi dalje trebale biti jednostavnije
			
			Create
			
			Retrieve
			
			Update 
			
			Delete
			
