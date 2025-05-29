-- object: account_uk | type: CONSTRAINT --
-- ALTER TABLE public.account DROP CONSTRAINT IF EXISTS account_uk CASCADE;
ALTER TABLE public.account ADD CONSTRAINT account_uk UNIQUE (username);
-- ddl-end --

-- object: activity_category_uk | type: CONSTRAINT --
-- ALTER TABLE public.activity_category DROP CONSTRAINT IF EXISTS activity_category_uk CASCADE;
ALTER TABLE public.activity_category ADD CONSTRAINT activity_category_uk UNIQUE (name);
-- ddl-end --

