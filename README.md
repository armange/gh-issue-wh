# Github Webhook for issues event

#### This project was created to provide a webhook sample

#### To run this sample _(using Docker)_, perform the following steps

1. **Run the Postgres database.**

	_docker run -it -e "POSTGRES_PASSWORD=postgres" -p 5432:5432 --rm --name postgres-9.6.17 postgres:9.6.17_

2. **Run the webhook service.**

	_docker run -it --rm --name gh-issue-wh -e "SPRING_DATASOURCE_URL=jdbc:postgresql://pg-host:5432/postgres" -p 4321:4321 diegoarmangecosta/gh-issue-wh:1.0.0-SNAPSHOT_

	*NOTE: Change the postgres host address*

3. **Expose the service path to the Internet (using [ngrok](https://ngrok.com/download))**

	_ngrok http 4321_