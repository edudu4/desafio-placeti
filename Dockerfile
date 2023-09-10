FROM postgres

ENV POSTGRES_DB desafio
COPY init.sql /docker-entrypoint-initdb.d/
