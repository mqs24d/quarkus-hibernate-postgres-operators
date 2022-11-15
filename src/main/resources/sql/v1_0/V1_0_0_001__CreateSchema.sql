create table if not exists message
(
  id text primary key,
  value text,
  data jsonb
);
