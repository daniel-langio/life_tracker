-- object: life_tracking_app | type: ROLE --
-- DROP ROLE IF EXISTS life_tracking_app;
CREATE ROLE life_tracking_app WITH 
	CREATEDB
	CREATEROLE
	INHERIT
	LOGIN
	REPLICATION
	 PASSWORD 'life_track_app password'
	CONNECTION LIMIT 5;
-- ddl-end --

