CREATE TABLE fighttactics (
  id_fighttactics serial PRIMARY KEY,
  name_tactics varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
);

CREATE TABLE crews (
  id_crew serial PRIMARY KEY,
  name_crew varchar(255) NOT NULL,
  ship_name varchar(255) NOT NULL,
  number_pirate integer NOT NULL,
  poneglyph_id integer REFERENCES poneglyphs(id_poneglyph),
);

CREATE TABLE poneglyphs (
  id_poneglyph serial PRIMARY KEY,
  type varchar(255) NOT NULL,
  location varchar(255) NOT NULL,
  inscription_text varchar(255) NOT NULL
);

CREATE TABLE characters (
  id_character serial PRIMARY KEY,
  devilfruit_id integer REFERENCES devilfruits(id_devilfruit)
  crew_id integer REFERENCES crews(id_crew),
  haki_id integer REFERENCES haki(id_haki),
  fighttactics_id integer REFERENCES fighttactics(id_fighttactics),
  name_character varchar(255) NOT NULL,
  rank varchar(255) NOT NULL,
  job varchar(255) NOT NULL,
  bounty integer NOT NULL
);

CREATE TABLE haki (
  id_haki serial PRIMARY KEY,
  name_haki varchar(255) NOT NULL,
  description_haki varchar(255) NOT NULL
);

CREATE TABLE devilfruits (
  id_devilfruit serial PRIMARY KEY,
  name_fruit varchar(255) NOT NULL,
  abilities varchar(255) NOT NULL,
  type varchar(255) NOT NULL
);

