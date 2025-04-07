import postgres from 'postgres';
import config from './config';

let sql;

if (config.DB_TYPE === 'postgresql') {
    sql = postgres('postgres://username:password@host:port/database', {
        host                 : config.DB_HOST,            // Postgres ip address[s] or domain name[s]
        port                 : config.DB_PORT as unknown as number || 5432,          // Postgres server port[s]
        database             : config.DB_NAME,            // Name of database to connect to
        username             : config.DB_USERNAME,            // Username of database user
        password             : config.DB_PASSWORD            // Password of database user
    });
} else {
    throw new Error("DATABASE TYPE NOT SUPPORTED");  
}

export default sql;