-- object: fk_activity_category_id | type: CONSTRAINT --
-- ALTER TABLE public.activity DROP CONSTRAINT IF EXISTS fk_activity_category_id CASCADE;
ALTER TABLE public.activity
    ADD CONSTRAINT fk_activity_category_id FOREIGN KEY (category_id)
        REFERENCES public.activity_category (id) MATCH SIMPLE
        ON DELETE SET NULL ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_activity_account_id | type: CONSTRAINT --
-- ALTER TABLE public.activity DROP CONSTRAINT IF EXISTS fk_activity_account_id CASCADE;
ALTER TABLE public.activity
    ADD CONSTRAINT fk_activity_account_id FOREIGN KEY (account_id)
        REFERENCES public.account (id) MATCH SIMPLE
        ON DELETE SET NULL ON UPDATE NO ACTION;
-- ddl-end --

