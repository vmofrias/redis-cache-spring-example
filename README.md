# Redis Caching Spring Project


## Prerequisites

* Java 17
* Maven
* Shell Script
* Docker

## How to run

##### Enter in the project's directory then run the script to build and start the application with its dependencies:


```bash
  sh ./build-and-start.sh
```


## How to use it

#### Use these endpoints to:

#### GET - Get all products without cache results
##### - http://localhost:8080/products

#### GET - Get all products with cache results
##### - http://localhost:8080/products/cache

#### POST - Add ten thousand products in the database and evict all caches
##### - http://localhost:8080/products


#### Now try to add some products in the database and compare the time results with/without caching.
