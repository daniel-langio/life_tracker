-- object: activity_pk | type: CONSTRAINT --
-- ALTER TABLE public.activity DROP CONSTRAINT IF EXISTS activity_pk CASCADE;
ALTER TABLE public.activity ADD CONSTRAINT activity_pk PRIMARY KEY (id);
-- ddl-end --

-- object: activity_category_pk | type: CONSTRAINT --
-- ALTER TABLE public.activity_category DROP CONSTRAINT IF EXISTS activity_category_pk CASCADE;
ALTER TABLE public.activity_category ADD CONSTRAINT activity_category_pk PRIMARY KEY (id);
-- ddl-end --

-- object: account_pk | type: CONSTRAINT --
-- ALTER TABLE public.account DROP CONSTRAINT IF EXISTS account_pk CASCADE;
ALTER TABLE public.account ADD CONSTRAINT account_pk PRIMARY KEY (id);
-- ddl-end --

