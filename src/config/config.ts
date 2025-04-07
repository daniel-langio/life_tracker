import dotenv from 'dotenv';

dotenv.config();

const config = {
    // DATABASE
    DB_TYPE: process.env.DB_TYPE as string,
    DB_HOST: process.env.DB_HOST as string,
    DB_PORT: process.env.DB_PORT as unknown as number,
    DB_NAME: process.env.DB_NAME as string,
    DB_USERNAME: process.env.DB_USERNAME as string,
    DB_PASSWORD: process.env.DB_PASSWORD as string,

};

export default config;