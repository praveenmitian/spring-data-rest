# Spring Data Rest

We are not creating any controller or endpoint for accessing the resource, by using spring data rest based on entity we do CRUD operation without creating controller or endpoint.

DB value on start up


|ID  |	EMAIL  |	NAME |
|----  | ------- |  -------|
|1	| praveen@gmail.com	| Praveen|
|2	| ram@gmail.com	| Ram|
|3	| dileep@gmail.com	| Dileep|
|4	| anil@gmail.com	| Anil|

### Output

After starting the application go to http://localhost:8081/
```json
{
  "_links" : {
    "users" : {
      "href" : "http://localhost:8081/users{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8081/profile"
    }
  }
}
```

```java
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<ApplicationUser, Integer> {
}
```

@RepositoryRestResource specifies the path for auto generated endpoint. Without this endpoint generated will be same as entity class name like below.

```json
{
  "_links" : {
    "applicationUsers" : {
      "href" : "http://localhost:8081/applicationUsers{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8081/profile"
    }
  }
}
```

`GET http://localhost:8081/users`
```json
{
  "_embedded" : {
    "users" : [ {
      "name" : "Praveen",
      "email" : "praveen@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/1"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/1"
        }
      }
    }, {
      "name" : "Ram",
      "email" : "ram@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/2"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/2"
        }
      }
    }, {
      "name" : "Dileep",
      "email" : "dileep@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/3"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/3"
        }
      }
    }, {
      "name" : "Anil",
      "email" : "anil@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/4"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/4"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8081/users"
    },
    "profile" : {
      "href" : "http://localhost:8081/profile/users"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 4,
    "totalPages" : 1,
    "number" : 0
  }
}
```
`GET http://localhost:8081/users/2`
```json
{
  "name" : "Ram",
  "email" : "ram@gmail.com",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8081/users/2"
    },
    "applicationUser" : {
      "href" : "http://localhost:8081/users/2"
    }
  }
}
```

`POST http://localhost:8081/users`
```json
{
  "id": "5",
  "name": "Emy",
  "email": "emy@gmail.com"
}
```
|ID  |	EMAIL  |	NAME |
|----  | ------- |  -------|
|1	| praveen@gmail.com	| Praveen|
|2	| ram@gmail.com	| Ram|
|3	| dileep@gmail.com	| Dileep|
|4	| anil@gmail.com	| Anil|
|5	| emy@gmail.com	| Emy|

`PUT http://localhost:8081/users/1`
```json
{
  "id": "4",
  "name": "Anil",
  "email": "anil@outlook.com"
}
```
|ID  |	EMAIL  |	NAME |
|----  | ------- |  -------|
|1	| praveen@gmail.com	| Praveen|
|2	| ram@gmail.com	| Ram|
|3	| dileep@gmail.com	| Dileep|
|4	| anil@outlook.com	| Anil|
|5	| emy@gmail.com	| Emy|

`DELETE http://localhost:8081/users/5`

|ID  |	EMAIL  |	NAME |
|----  | ------- |  -------|
|1	| praveen@gmail.com	| Praveen|
|2	| ram@gmail.com	| Ram|
|3	| dileep@gmail.com	| Dileep|
|4	| anil@gmail.com	| Anil|

`GET http://localhost:8081/users?page=0&size=2`
```json
{
  "_embedded" : {
    "users" : [ {
      "name" : "Praveen",
      "email" : "praveen@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/1"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/1"
        }
      }
    }, {
      "name" : "Ram",
      "email" : "ram@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/2"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/2"
        }
      }
    } ]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8081/users?page=0&size=2"
    },
    "self" : {
      "href" : "http://localhost:8081/users?page=0&size=2"
    },
    "next" : {
      "href" : "http://localhost:8081/users?page=1&size=2"
    },
    "last" : {
      "href" : "http://localhost:8081/users?page=1&size=2"
    },
    "profile" : {
      "href" : "http://localhost:8081/profile/users"
    }
  },
  "page" : {
    "size" : 2,
    "totalElements" : 4,
    "totalPages" : 2,
    "number" : 0
  }
}
```
`GET http://localhost:8081/users?page=2&size=1`
```json
{
  "_embedded" : {
    "users" : [ {
      "name" : "Dileep",
      "email" : "dileep@gmail.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8081/users/3"
        },
        "applicationUser" : {
          "href" : "http://localhost:8081/users/3"
        }
      }
    } ]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8081/users?page=0&size=1"
    },
    "prev" : {
      "href" : "http://localhost:8081/users?page=1&size=1"
    },
    "self" : {
      "href" : "http://localhost:8081/users?page=2&size=1"
    },
    "next" : {
      "href" : "http://localhost:8081/users?page=3&size=1"
    },
    "last" : {
      "href" : "http://localhost:8081/users?page=3&size=1"
    },
    "profile" : {
      "href" : "http://localhost:8081/profile/users"
    }
  },
  "page" : {
    "size" : 1,
    "totalElements" : 4,
    "totalPages" : 4,
    "number" : 2
  }
}
```

We can add our own method to get by value field.

`ApplicationUser findByEmail(@Param("email") String email);`
`GET http://localhost:8081/users/search/findByEmail?email=praveen@gmail.com`
```json
{
  "name" : "Praveen",
  "email" : "praveen@gmail.com",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8081/users/1"
    },
    "applicationUser" : {
      "href" : "http://localhost:8081/users/1"
    }
  }
}
```
