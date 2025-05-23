--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-23 19:54:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 17169)
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medico (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    crm character varying(20) NOT NULL,
    especialidade character varying(50) NOT NULL
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 4890 (class 0 OID 17169)
-- Dependencies: 217
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medico (id, nome, crm, especialidade) FROM stdin;
2	rodrigo	2512	medico olho
\.


--
-- TOC entry 4742 (class 2606 OID 17175)
-- Name: medico medico_crm_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_crm_key UNIQUE (crm);


--
-- TOC entry 4744 (class 2606 OID 17173)
-- Name: medico medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id);


-- Completed on 2025-05-23 19:54:24

--
-- PostgreSQL database dump complete
--

