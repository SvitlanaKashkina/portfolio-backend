--
-- PostgreSQL database dump
--

\restrict M8ASBBbVZ3xAUS4IHKkPZd9OPWdpU15zY512G6ZcJefAWuFGluntWQeyPbTk9fb

-- Dumped from database version 17.6
-- Dumped by pg_dump version 17.6

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
-- Name: about_me; Type: TABLE; Schema: public; Owner: skashkina
--

CREATE TABLE public.about_me (
    id bigint NOT NULL,
    section_key character varying(50) NOT NULL,
    title character varying(255) NOT NULL,
    content text
);


ALTER TABLE public.about_me OWNER TO skashkina;

--
-- Name: about_me_id_seq; Type: SEQUENCE; Schema: public; Owner: skashkina
--

CREATE SEQUENCE public.about_me_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.about_me_id_seq OWNER TO skashkina;

--
-- Name: about_me_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: skashkina
--

ALTER SEQUENCE public.about_me_id_seq OWNED BY public.about_me.id;


--
-- Name: certificates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.certificates (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    issuer character varying(255),
    year integer,
    display_order integer
);


ALTER TABLE public.certificates OWNER TO postgres;

--
-- Name: certificates_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.certificates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.certificates_id_seq OWNER TO postgres;

--
-- Name: certificates_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.certificates_id_seq OWNED BY public.certificates.id;


--
-- Name: contact_messages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact_messages (
    id bigint NOT NULL,
    name character varying(100),
    email character varying(100) NOT NULL,
    subject character varying(150),
    message text NOT NULL,
    phone character varying(20),
    consent boolean NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.contact_messages OWNER TO postgres;

--
-- Name: contact_messages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contact_messages_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.contact_messages_id_seq OWNER TO postgres;

--
-- Name: contact_messages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contact_messages_id_seq OWNED BY public.contact_messages.id;


--
-- Name: home_content; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.home_content (
    id integer NOT NULL,
    full_name character varying(255) NOT NULL,
    role_title character varying(255) NOT NULL,
    role_type character varying(255),
    short_bio text,
    github_url character varying(255),
    linkedin_url character varying(255),
    created_at timestamp without time zone DEFAULT now(),
    updated_at timestamp without time zone DEFAULT now()
);


ALTER TABLE public.home_content OWNER TO postgres;

--
-- Name: home_content_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.home_content_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.home_content_id_seq OWNER TO postgres;

--
-- Name: home_content_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.home_content_id_seq OWNED BY public.home_content.id;


--
-- Name: project_features; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_features (
    id bigint NOT NULL,
    project_id bigint NOT NULL,
    description character varying(500) NOT NULL,
    display_order integer
);


ALTER TABLE public.project_features OWNER TO postgres;

--
-- Name: project_features_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_features_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.project_features_id_seq OWNER TO postgres;

--
-- Name: project_features_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_features_id_seq OWNED BY public.project_features.id;


--
-- Name: project_screenshots; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_screenshots (
    id bigint NOT NULL,
    project_id bigint NOT NULL,
    image_url character varying(1000) NOT NULL,
    alt_text character varying(255),
    display_order integer
);


ALTER TABLE public.project_screenshots OWNER TO postgres;

--
-- Name: project_screenshots_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_screenshots_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.project_screenshots_id_seq OWNER TO postgres;

--
-- Name: project_screenshots_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_screenshots_id_seq OWNED BY public.project_screenshots.id;


--
-- Name: project_technologies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_technologies (
    project_id bigint NOT NULL,
    technology_id bigint NOT NULL
);


ALTER TABLE public.project_technologies OWNER TO postgres;

--
-- Name: projects; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projects (
    id bigint NOT NULL,
    title character varying(255) NOT NULL,
    short_description text NOT NULL,
    full_description text,
    architecture_description text,
    role_description text,
    lessons_learned text,
    status text,
    end_date date,
    github_url text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.projects OWNER TO postgres;

--
-- Name: projects_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.projects_id_seq OWNER TO postgres;

--
-- Name: projects_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.projects_id_seq OWNED BY public.projects.id;


--
-- Name: soft_skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soft_skill (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    order_index integer NOT NULL
);


ALTER TABLE public.soft_skill OWNER TO postgres;

--
-- Name: soft_skill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.soft_skill_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.soft_skill_id_seq OWNER TO postgres;

--
-- Name: soft_skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soft_skill_id_seq OWNED BY public.soft_skill.id;


--
-- Name: tech_stack_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tech_stack_category (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    order_index integer NOT NULL
);


ALTER TABLE public.tech_stack_category OWNER TO postgres;

--
-- Name: tech_stack_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tech_stack_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tech_stack_category_id_seq OWNER TO postgres;

--
-- Name: tech_stack_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tech_stack_category_id_seq OWNED BY public.tech_stack_category.id;


--
-- Name: tech_stack_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tech_stack_item (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    category_id integer NOT NULL,
    order_index integer NOT NULL
);


ALTER TABLE public.tech_stack_item OWNER TO postgres;

--
-- Name: tech_stack_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tech_stack_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tech_stack_item_id_seq OWNER TO postgres;

--
-- Name: tech_stack_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tech_stack_item_id_seq OWNED BY public.tech_stack_item.id;


--
-- Name: technical_skill_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.technical_skill_category (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    order_index integer NOT NULL
);


ALTER TABLE public.technical_skill_category OWNER TO postgres;

--
-- Name: technical_skill_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.technical_skill_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.technical_skill_category_id_seq OWNER TO postgres;

--
-- Name: technical_skill_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.technical_skill_category_id_seq OWNED BY public.technical_skill_category.id;


--
-- Name: technical_skill_item; Type: TABLE; Schema: public; Owner: skashkina
--

CREATE TABLE public.technical_skill_item (
    id bigint NOT NULL,
    category_id bigint NOT NULL,
    description character varying(255) NOT NULL,
    order_index integer NOT NULL
);


ALTER TABLE public.technical_skill_item OWNER TO skashkina;

--
-- Name: technical_skill_item_id_seq; Type: SEQUENCE; Schema: public; Owner: skashkina
--

CREATE SEQUENCE public.technical_skill_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.technical_skill_item_id_seq OWNER TO skashkina;

--
-- Name: technical_skill_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: skashkina
--

ALTER SEQUENCE public.technical_skill_item_id_seq OWNED BY public.technical_skill_item.id;


--
-- Name: technologies; Type: TABLE; Schema: public; Owner: skashkina
--

CREATE TABLE public.technologies (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    category character varying(100)
);


ALTER TABLE public.technologies OWNER TO skashkina;

--
-- Name: technologies_id_seq; Type: SEQUENCE; Schema: public; Owner: skashkina
--

CREATE SEQUENCE public.technologies_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.technologies_id_seq OWNER TO skashkina;

--
-- Name: technologies_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: skashkina
--

ALTER SEQUENCE public.technologies_id_seq OWNED BY public.technologies.id;


--
-- Name: about_me id; Type: DEFAULT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.about_me ALTER COLUMN id SET DEFAULT nextval('public.about_me_id_seq'::regclass);


--
-- Name: certificates id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificates ALTER COLUMN id SET DEFAULT nextval('public.certificates_id_seq'::regclass);


--
-- Name: contact_messages id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_messages ALTER COLUMN id SET DEFAULT nextval('public.contact_messages_id_seq'::regclass);


--
-- Name: home_content id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.home_content ALTER COLUMN id SET DEFAULT nextval('public.home_content_id_seq'::regclass);


--
-- Name: project_features id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_features ALTER COLUMN id SET DEFAULT nextval('public.project_features_id_seq'::regclass);


--
-- Name: project_screenshots id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_screenshots ALTER COLUMN id SET DEFAULT nextval('public.project_screenshots_id_seq'::regclass);


--
-- Name: projects id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projects ALTER COLUMN id SET DEFAULT nextval('public.projects_id_seq'::regclass);


--
-- Name: soft_skill id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soft_skill ALTER COLUMN id SET DEFAULT nextval('public.soft_skill_id_seq'::regclass);


--
-- Name: tech_stack_category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tech_stack_category ALTER COLUMN id SET DEFAULT nextval('public.tech_stack_category_id_seq'::regclass);


--
-- Name: tech_stack_item id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tech_stack_item ALTER COLUMN id SET DEFAULT nextval('public.tech_stack_item_id_seq'::regclass);


--
-- Name: technical_skill_category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technical_skill_category ALTER COLUMN id SET DEFAULT nextval('public.technical_skill_category_id_seq'::regclass);


--
-- Name: technical_skill_item id; Type: DEFAULT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.technical_skill_item ALTER COLUMN id SET DEFAULT nextval('public.technical_skill_item_id_seq'::regclass);


--
-- Name: technologies id; Type: DEFAULT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.technologies ALTER COLUMN id SET DEFAULT nextval('public.technologies_id_seq'::regclass);


--
-- Data for Name: about_me; Type: TABLE DATA; Schema: public; Owner: skashkina
--

COPY public.about_me (id, section_key, title, content) FROM stdin;
4	certificates	Zertifikate	\N
3	education	Bildung	Ich habe meine schulische Ausbildung in der Ukraine mit dem Abschluss der Realschule (11 Klassen) erfolgreich abgeschlossen. Anschließend habe ich zwei Studiengänge an Universitäten in der Ukraine absolviert: zuerst einen Bachelor in Rechtswissenschaften und danach einen Abschluss in Accounting und Auditing.
5	hobbies	Hobbys und Interessen	Schon seit meiner Kindheit bin ich körperlich sehr aktiv und neugierig. Sport und Bewegung gehören fest zu meinem Alltag: Ich jogge regelmäßig und spiele mit großer Leidenschaft Tennis. Außerdem reise ich unglaublich gern – neue Länder, Kulturen und Menschen kennenzulernen erweitert meinen Horizont und inspiriert mich. Diese Erlebnisse bereichern nicht nur mein Leben, sondern bringen mir auch neue Perspektiven und Ideen, die ich in meine Arbeit und meinen Alltag einfließen lasse.
1	about	Über mich	Mein Name ist Svitlana Kashkina und ich bin Java-Softwareentwicklerin mit Schwerpunkt auf Backend- und Fullstack-Technologien. Erste praktische Erfahrungen in der Entwicklung von Mobile- und Webanwendungen habe ich während einer Praxisphase bei der Schlote Holding GmbH sowie durch persönliche Projekte gesammelt. Ich löse gerne reale Probleme durch sauberen Code und effizientes Systemdesign. Dabei nutze ich jede Gelegenheit, in Projekten und Weiterbildungen neue Fähigkeiten zu erwerben und bestehende zu vertiefen. Mein Ziel ist es, zuverlässige Backend-Lösungen für moderne Anwendungen zu entwickeln.
2	experience	Berufserfahrung	Mein beruflicher Weg begann in einem Sportverein, wo ich als Assistentin der Geschäftsführung tätig war. Anschließend arbeitete ich in mehreren Banken und sammelte vielfältige Erfahrungen.\nSchon lange träumte ich davon, meinen Beruf zu wechseln, und nach meiner Ankunft in Deutschland wurde dieser Traum Wirklichkeit. Da meine bisherigen Diplome hier nicht anerkannt wurden, entschied ich mich für eine Umschulung zur Fachinformatikerin für Anwendungsentwicklung. Während dieser Umschulung konnte ich erste praktische Erfahrungen in der Full-Stack-Softwareentwicklung sammeln und an eigenen Projekten arbeiten. Dabei arbeitete ich mit Technologien wie Java, Spring Boot, Hibernate, React Native (Expo), Vue.js, Docker und weiteren. Diese Erfahrungen halfen mir, den gesamten Entwicklungsprozess von mobilen und Webanwendungen zu verstehen – von der Konzeption über die Implementierung bis hin zu Testing und Deployment.\n
\.


--
-- Data for Name: certificates; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.certificates (id, name, issuer, year, display_order) FROM stdin;
1	Java - Complete Java Course	Udemy	2025	1
2	Spring Boot - Development Java web applications	Udemy	2025	2
3	Docker & Kubernetes: The complete practical guide	Udemy	2025	3
4	The complete Apache Kafka practical guide	Udemy	2025	4
5	Git und GitHub	LinkedIn	2024	5
6	IntelliJ IDEA Grundkurs	LinkedIn	2024	6
7	Visual Studio Code Grundkurs	LinkedIn	2024	7
8	Fachfrau fur Projektmanagement	DEKRA	2024	8
\.


--
-- Data for Name: contact_messages; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contact_messages (id, name, email, subject, message, phone, consent, created_at) FROM stdin;
19	Svitlana Svitlana	sv4074@gmail.com	Test1	<fg<dgyhcgjnmcj		t	\N
20	Svitlana Svitlana	sv4074@gmail.com	test2	csdgsg	123456789	t	\N
21	Svitlana Svitlana	sv4074@gmail.com	test3	<yad<asf	123456789	t	\N
22	Svitlana Svitlana	sv4074@gmail.com	test3	<yad<asf		t	\N
23	Svitlana Svitlana	sv4074@gmail.com	test3	y<asfgadfg	017674576176	t	\N
24	Svitlana Svitlana	sv4074@gmail.com	test5	<ysfafafg		t	\N
25	Svitlana Svitlana	sv4074@gmail.com	test7	ysfaygg		t	\N
26	Svitlana Svitlana	sv4074@gmail.com	test8	xs<afasf		t	\N
27	Svitlana Svitlana	sv4074@gmail.com	test9	yafadffa		t	\N
28	Svitlana Svitlana	sv4074@gmail.com	test10	sgsfhgs		t	\N
29	Svitlana Svitlana	sv4074@gmail.com	test11	ыавпыпы	017674576176	t	\N
30	Svitlana Svitlana	sv4074@gmail.com	test12	asfg		t	\N
31	Svitlana Svitlana	sv4074@gmail.com	test13	dsgfsdg		t	\N
32	Svitlana Svitlana	sv4074@gmail.com	test14	asfraettaq		t	\N
33	Svitlana Svitlana	sv4074@gmail.com	test15	<sfsfag		t	\N
34	Svitlana Svitlana	sv4074@gmail.com	test16	<sdsafatgatg		t	\N
35	Svitlana Svitlana	sv4074@gmail.com	test20	atqaett		t	\N
36	Svitlana Svitlana	sv4074@gmail.com	test21	sgsswrz		t	\N
37	Svitlana Svitlana	sv4074@gmail.com	test22	ADFF		t	\N
38	Svitlana Svitlana	k.svitlana@web.de	test30	ad		t	\N
39	Svitlana Kashkina	k.svitlana@web.de	fgjhfj	fjfkj	017674576176	t	\N
40	Svitlana Kashkina	k.svitlana@web.de	test30	<sfdf	017674576176	t	\N
41	Svitlana Kashkina	sv4074@gmail.com	test31	ARRW	017674576176	t	\N
42	Svitlana Kashkina	k.svitlana@web.de	test33	<ffdgg	017674576176	t	\N
43	Svitlana Kashkina	k.svitlana@web.de	test34	<fc<sfaf	017674576176	t	\N
44	Svitlana Kashkina	k.svitlana@web.de	test35	a<dasf	017674576176	t	\N
45	Svitlana Kashkina	k.svitlana@web.de	test36	fgdztzu	017674576176	t	\N
46	Svitlana Kashkina	k.svitlana@web.de	test37	ghjfj	017674576176	t	\N
47	Svitlana Svitlana	k.svitlana@web.de	test340	fddh		t	\N
48	Svitlana Kashkina	k.svitlana@web.de	test42	fdhdhduzh	017674576176	t	\N
49	Svitlana Svitlana	sv4074@gmail.com	test44	gjffkj	017674576176	t	\N
\.


--
-- Data for Name: home_content; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.home_content (id, full_name, role_title, role_type, short_bio, github_url, linkedin_url, created_at, updated_at) FROM stdin;
1	Svitlana Kashkina	Java Softwareentwicklerin	Backend & Fullstack	Für mich sind Java, Spring Boot, Vue und JavaScript nicht nur Werkzeuge, sondern ein fester Bestandteil meines Lebens und meiner Art zu denken. Mit ihrer Hilfe setze ich Ideen in kreative und funktionierende Anwendungen um.	https://github.com/SvitlanaKashkina	https://www.linkedin.com/in/svitlana-kashkina-12a0922b4/	2026-01-19 12:49:58.219876	2026-01-19 12:49:58.219876
\.


--
-- Data for Name: project_features; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_features (id, project_id, description, display_order) FROM stdin;
19	1	Real-time communication via WebSockets (Socket.IO)	1
20	1	Real-time message delivery and persistence	2
21	1	User authentication and authorization with role-based access control	3
22	1	User profile management	4
23	1	News system with card-based content (text and images)	5
24	1	Media support for chat and news content	6
25	1	Push notifications for real-time updates	7
26	1	Feedback submission via email	8
27	1	Secure client-server communication using HTTPS (SSL)	9
\.


--
-- Data for Name: project_screenshots; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_screenshots (id, project_id, image_url, alt_text, display_order) FROM stdin;
12	1	/images/projects/Auth.png	Login Screen	1
13	1	/images/projects/Chat.png	Chat Screen	2
14	1	/images/projects/Feedback.png	Feedback Screen	3
\.


--
-- Data for Name: project_technologies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_technologies (project_id, technology_id) FROM stdin;
1	1
1	2
1	3
1	4
1	5
1	6
1	7
1	8
1	9
1	10
1	11
1	12
1	13
1	14
1	15
\.


--
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.projects (id, title, short_description, full_description, architecture_description, role_description, lessons_learned, status, end_date, github_url, created_at, updated_at) FROM stdin;
1	Mobile Communication App	Mobile Communication App is a full-stack mobile application designed for internal communication. It is a personal graduation project aimed at demonstrating practical mobile and backend development skills.	Mobile Communication App is a full-stack mobile application designed for internal communication.	The project follows a classic client-server architecture with a mobile frontend and a centralized backend.\nThe client is a React Native application (Expo) that communicates with the backend via RESTful APIs for standard data operations and WebSockets (Socket.IO) for real-time features such as chat and live updates.\nThe backend is implemented as a monolithic Node.js application using Express.js, structured according to the MVC pattern (routes, controllers, and Prisma models). It handles business logic, authentication, and communication with the database.\nThe persistence layer is based on PostgreSQL, with Prisma ORM used for database access, data modeling, and query management.\nReal-time functionality is enabled through a dedicated WebSocket layer, ensuring immediate message delivery and synchronization between connected clients.\nSecurity is ensured through JWT-based authentication and authorization and encrypted HTTPS communication using SSL certificates.\nThe architecture was designed with scalability and extensibility in mind, allowing future enhancements such as additional real-time features or service separation	I worked as a solo full-stack developer, responsible for the end-to-end development of the application. My responsibilities included designing and implementing the mobile frontend, backend architecture, database schema, and APIs, as well as defining the overall system design and user experience. Key architectural and functional decisions were discussed and validated with my supervisor during regular reviews.	Gained experience in full-stack mobile development, including frontend, backend, database design, REST APIs, WebSockets, and secure client-server communication, and strengthened my ability to develop an entire application independently, from design to deployment.	Completed - fully implemented full-stack mobile application with all planned features	2025-12-31	https://github.com/SvitlanaKashkina	2026-01-25 14:23:04.749067	2026-01-25 14:23:04.749067
\.


--
-- Data for Name: soft_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.soft_skill (id, name, order_index) FROM stdin;
8	Logical and analytical thinking	1
9	Problem-solving skills	2
10	Teamwork and clear communication	3
11	Self-directed learning and organization	4
12	Writing clean code and maintaining architecture	5
13	Attention to detail and precision	6
\.


--
-- Data for Name: tech_stack_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tech_stack_category (id, name, order_index) FROM stdin;
1	Programming Languages	1
2	Frameworks & Libraries	2
3	Databases & ORM	3
4	DevOps & Tools	4
5	Frontend & Styling	5
6	Testing	6
7	Messaging & Event Streaming	7
8	API & Communication	8
\.


--
-- Data for Name: tech_stack_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tech_stack_item (id, name, category_id, order_index) FROM stdin;
1	Java	1	1
2	JavaScript	1	2
3	Spring Boot	2	1
4	Hibernate	2	2
5	Vue.js	2	3
6	React Native (Expo)	2	4
7	Node.js	2	5
8	Express.js	2	6
9	NativeBase	2	7
11	PostgreSQL	3	1
12	Prisma ORM	3	2
13	Docker	4	1
14	Kubernetes	4	2
15	Git	4	3
16	GitHub	4	4
17	Maven	4	5
18	IntelliJ IDEA	4	6
19	Visual Studio Code	4	7
20	HTML	5	1
21	CSS	5	2
22	Tailwind CSS	5	3
23	JUnit	6	1
24	Apache Kafka	7	1
25	RESTful APIs	8	1
26	WebSockets	8	2
27	Expo Notifications	8	3
28	Lombok	2	8
\.


--
-- Data for Name: technical_skill_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.technical_skill_category (id, name, order_index) FROM stdin;
1	Backend Development (Java / Spring Boot)	1
2	Frontend Development (Vue.js)	2
3	Database & Data Modeling	3
4	API & Real-Time Communication	4
5	Messaging & Event Streaming	5
6	DevOps & Development Tools	6
7	Testing	7
\.


--
-- Data for Name: technical_skill_item; Type: TABLE DATA; Schema: public; Owner: skashkina
--

COPY public.technical_skill_item (id, category_id, description, order_index) FROM stdin;
1	1	Development of RESTful APIs using Spring Boot	1
2	1	Implementation of business logic and application layers	2
3	1	Data persistence with Spring Data JPA and Hibernate	3
4	1	Request validation and global exception handling	4
5	1	Integration of PostgreSQL databases	5
6	1	Authentication and authorization concepts (JWT / session-based)	6
7	1	Building scalable backend architectures	7
8	2	Development of Single Page Applications (SPA) with Vue.js	1
9	2	Component-based UI architecture	2
10	2	State management and routing	3
11	2	API integration using Axios	4
12	2	Form handling and client-side validation	5
13	2	Responsive UI implementation	6
14	3	Relational database design using PostgreSQL	1
15	3	Creating normalized database schemas	2
16	3	Writing complex SQL queries (JOINs, subqueries)	3
17	3	Managing entity relationships (One-to-Many, Many-to-Many)	4
18	3	ORM usage with Prisma and Hibernate	5
19	4	Design and consumption of RESTful APIs	1
20	4	Real-time communication using WebSockets	2
21	4	Push notifications integration (Expo Notifications)	3
22	5	Asynchronous communication using Apache Kafka	1
23	5	Producer and consumer implementation	2
24	5	Event-driven architecture concepts	3
25	6	Version control with Git and GitHub	1
26	6	Containerization using Docker	2
27	6	Basic container orchestration with Kubernetes	3
28	6	Build and dependency management with Maven	4
29	6	API testing with Postman	5
30	6	Development using IntelliJ IDEA and Visual Studio Code	6
31	7	Unit testing with JUnit	1
\.


--
-- Data for Name: technologies; Type: TABLE DATA; Schema: public; Owner: skashkina
--

COPY public.technologies (id, name, category) FROM stdin;
1	React Native (Expo)	Frontend
2	JavaScript	Frontend
3	NativeBase (UI Library)	Frontend
4	Axios	Frontend
5	Node.js	Backend
6	Express.js	Backend
7	Prisma ORM	Backend
8	RESTful API	Backend
9	WebSockets (Socket.IO)	Backend
10	Nodemailer	Backend
11	HTTPS / SSL	Backend
12	PostgreSQL	Database
13	Visual Studio Code	Tool
14	GitHub	Tool
15	Expo Notifications	Tool
\.


--
-- Name: about_me_id_seq; Type: SEQUENCE SET; Schema: public; Owner: skashkina
--

SELECT pg_catalog.setval('public.about_me_id_seq', 5, true);


--
-- Name: certificates_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.certificates_id_seq', 8, true);


--
-- Name: contact_messages_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contact_messages_id_seq', 49, true);


--
-- Name: home_content_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.home_content_id_seq', 1, true);


--
-- Name: project_features_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_features_id_seq', 27, true);


--
-- Name: project_screenshots_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_screenshots_id_seq', 15, true);


--
-- Name: projects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.projects_id_seq', 1, true);


--
-- Name: soft_skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soft_skill_id_seq', 13, true);


--
-- Name: tech_stack_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tech_stack_category_id_seq', 8, true);


--
-- Name: tech_stack_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tech_stack_item_id_seq', 27, true);


--
-- Name: technical_skill_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.technical_skill_category_id_seq', 7, true);


--
-- Name: technical_skill_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: skashkina
--

SELECT pg_catalog.setval('public.technical_skill_item_id_seq', 31, true);


--
-- Name: technologies_id_seq; Type: SEQUENCE SET; Schema: public; Owner: skashkina
--

SELECT pg_catalog.setval('public.technologies_id_seq', 15, true);


--
-- Name: about_me about_me_pkey; Type: CONSTRAINT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.about_me
    ADD CONSTRAINT about_me_pkey PRIMARY KEY (id);


--
-- Name: about_me about_me_section_key_key; Type: CONSTRAINT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.about_me
    ADD CONSTRAINT about_me_section_key_key UNIQUE (section_key);


--
-- Name: certificates certificates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificates
    ADD CONSTRAINT certificates_pkey PRIMARY KEY (id);


--
-- Name: contact_messages contact_messages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_messages
    ADD CONSTRAINT contact_messages_pkey PRIMARY KEY (id);


--
-- Name: home_content home_content_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.home_content
    ADD CONSTRAINT home_content_pkey PRIMARY KEY (id);


--
-- Name: project_features project_features_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_features
    ADD CONSTRAINT project_features_pkey PRIMARY KEY (id);


--
-- Name: project_screenshots project_screenshots_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_screenshots
    ADD CONSTRAINT project_screenshots_pkey PRIMARY KEY (id);


--
-- Name: project_technologies project_technologies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_technologies
    ADD CONSTRAINT project_technologies_pkey PRIMARY KEY (project_id, technology_id);


--
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id);


--
-- Name: soft_skill soft_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soft_skill
    ADD CONSTRAINT soft_skill_pkey PRIMARY KEY (id);


--
-- Name: tech_stack_category tech_stack_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tech_stack_category
    ADD CONSTRAINT tech_stack_category_pkey PRIMARY KEY (id);


--
-- Name: tech_stack_item tech_stack_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tech_stack_item
    ADD CONSTRAINT tech_stack_item_pkey PRIMARY KEY (id);


--
-- Name: technical_skill_category technical_skill_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technical_skill_category
    ADD CONSTRAINT technical_skill_category_pkey PRIMARY KEY (id);


--
-- Name: technical_skill_item technical_skill_item_pkey; Type: CONSTRAINT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.technical_skill_item
    ADD CONSTRAINT technical_skill_item_pkey PRIMARY KEY (id);


--
-- Name: technologies technologies_name_key; Type: CONSTRAINT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.technologies
    ADD CONSTRAINT technologies_name_key UNIQUE (name);


--
-- Name: technologies technologies_pkey; Type: CONSTRAINT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.technologies
    ADD CONSTRAINT technologies_pkey PRIMARY KEY (id);


--
-- Name: project_technologies fk_project; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_technologies
    ADD CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES public.projects(id) ON DELETE CASCADE;


--
-- Name: project_features fk_project_feature; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_features
    ADD CONSTRAINT fk_project_feature FOREIGN KEY (project_id) REFERENCES public.projects(id) ON DELETE CASCADE;


--
-- Name: project_screenshots fk_project_screenshot; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_screenshots
    ADD CONSTRAINT fk_project_screenshot FOREIGN KEY (project_id) REFERENCES public.projects(id) ON DELETE CASCADE;


--
-- Name: tech_stack_item fk_tech_stack_category; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tech_stack_item
    ADD CONSTRAINT fk_tech_stack_category FOREIGN KEY (category_id) REFERENCES public.tech_stack_category(id) ON DELETE CASCADE;


--
-- Name: technical_skill_item fk_technical_skill_category; Type: FK CONSTRAINT; Schema: public; Owner: skashkina
--

ALTER TABLE ONLY public.technical_skill_item
    ADD CONSTRAINT fk_technical_skill_category FOREIGN KEY (category_id) REFERENCES public.technical_skill_category(id) ON DELETE CASCADE;


--
-- Name: project_technologies fk_technology; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_technologies
    ADD CONSTRAINT fk_technology FOREIGN KEY (technology_id) REFERENCES public.technologies(id) ON DELETE CASCADE;


--
-- Name: TABLE certificates; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.certificates TO skashkina;


--
-- Name: SEQUENCE certificates_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.certificates_id_seq TO skashkina;


--
-- Name: TABLE contact_messages; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.contact_messages TO skashkina;


--
-- Name: SEQUENCE contact_messages_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.contact_messages_id_seq TO skashkina;


--
-- Name: TABLE home_content; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.home_content TO skashkina;


--
-- Name: SEQUENCE home_content_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.home_content_id_seq TO skashkina;


--
-- Name: TABLE project_features; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.project_features TO skashkina;


--
-- Name: SEQUENCE project_features_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.project_features_id_seq TO skashkina;


--
-- Name: TABLE project_screenshots; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.project_screenshots TO skashkina;


--
-- Name: SEQUENCE project_screenshots_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.project_screenshots_id_seq TO skashkina;


--
-- Name: TABLE project_technologies; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.project_technologies TO skashkina;


--
-- Name: TABLE projects; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.projects TO skashkina;


--
-- Name: SEQUENCE projects_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.projects_id_seq TO skashkina;


--
-- Name: TABLE soft_skill; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.soft_skill TO skashkina;


--
-- Name: SEQUENCE soft_skill_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.soft_skill_id_seq TO skashkina;


--
-- Name: TABLE tech_stack_category; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.tech_stack_category TO skashkina;


--
-- Name: SEQUENCE tech_stack_category_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.tech_stack_category_id_seq TO skashkina;


--
-- Name: TABLE tech_stack_item; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.tech_stack_item TO skashkina;


--
-- Name: SEQUENCE tech_stack_item_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.tech_stack_item_id_seq TO skashkina;


--
-- Name: TABLE technical_skill_category; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.technical_skill_category TO skashkina;


--
-- Name: SEQUENCE technical_skill_category_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.technical_skill_category_id_seq TO skashkina;


--
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO skashkina;


--
-- PostgreSQL database dump complete
--

\unrestrict M8ASBBbVZ3xAUS4IHKkPZd9OPWdpU15zY512G6ZcJefAWuFGluntWQeyPbTk9fb

