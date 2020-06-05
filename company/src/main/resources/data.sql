DROP TABLE IF EXISTS STORE;
DROP TABLE IF EXISTS COMPANY;

CREATE TABLE COMPANY (
    id VARCHAR(250) NOT NULL,
    user_owner VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    document VARCHAR(250) NOT NULL
);

CREATE TABLE STORE (
    id VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    company_id VARCHAR(250) NOT NULL,
    document VARCHAR(250) NOT NULL
);

INSERT INTO COMPANY (id, user_owner, name, document) VALUES
('dca57f7d-944b-49f0-aaa3-185abb5dc4bf','0635c81f-3e75-4e0f-a248-a919e9f0dde0','company fred 1','documento 1'),
('63809460-01d7-4fa8-af23-fd296aa5abd5','0635c81f-3e75-4e0f-a248-a919e9f0dde0','company fred 2','documento 2');

INSERT INTO STORE (id, name, company_id, document) VALUES
('12bccedb-e862-4181-b399-362bd4958073','A','dca57f7d-944b-49f0-aaa3-185abb5dc4bf','docA'),
('680692d0-923d-4c08-907b-35b04e9b35d1','B','dca57f7d-944b-49f0-aaa3-185abb5dc4bf','docB'),
('47971a91-b192-4198-b8c5-9a84cc8e2267','C','dca57f7d-944b-49f0-aaa3-185abb5dc4bf','docC'),
('f37e3972-0c1f-43c8-8e61-53ec825f3060','D','63809460-01d7-4fa8-af23-fd296aa5abd5','docD');








