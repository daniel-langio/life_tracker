-- object: public.activity | type: TABLE --
-- DROP TABLE IF EXISTS public.activity CASCADE;
CREATE TABLE public.activity
(
    id          varchar NOT NULL,
    title       varchar,
    description text,
    started_at  timestamp,
    finished_at timestamp,
    category_id varchar,
    account_id  varchar

);
-- ddl-end --
ALTER TABLE public.activity
    OWNER TO life_tracking_app;
-- ddl-end --

-- object: public.activity_category | type: TABLE --
-- DROP TABLE IF EXISTS public.activity_category CASCADE;
CREATE TABLE public.activity_category
(
    id          varchar NOT NULL,
    name        varchar,
    description text,
    created_at  timestamp DEFAULT CURRENT_DATE::TIMESTAMP

);
-- ddl-end --
ALTER TABLE public.activity_category
    OWNER TO life_tracking_app;
-- ddl-end --

-- object: public.account | type: TABLE --
-- DROP TABLE IF EXISTS public.account CASCADE;
CREATE TABLE public.account
(
    id         varchar NOT NULL,
    username   varchar,
    created_at timestamp DEFAULT CURRENT_DATE::TIMESTAMP

);
-- ddl-end --
ALTER TABLE public.account
    OWNER TO life_tracking_app;
-- ddl-end --

