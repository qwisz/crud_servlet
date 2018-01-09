CREATE TABLE manufactures (
  id   BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE products (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  name           VARCHAR(255),
  price          DECIMAL,
  manufacture_id BIGINT,
  FOREIGN KEY (manufacture_id) REFERENCES manufactures (id),
  PRIMARY KEY (id)
)