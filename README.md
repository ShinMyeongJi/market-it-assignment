# Market-It 사전과제

## 개발환경
- java 8
- spring boot 2.4.4
- db : h2
- jpa


## API list
### 주문 접수 처리 API
```
PUT http://localhot:8080/api/orders/{id}/accept
```

### 주문 완료 처리 API
```
PUT http://localhot:8080/api/orders/{id}/complete
```

### 단일 주문 조회 API
```
GET http://localhot:8080/api/orders/{id}
```
```json
// response
{
    "httpStatus": "OK",
    "body": {
        "id": 1,
        "orderStatus": "CREATED",
        "orderItems": [
            {
                "name": "jeans",
                "cnt": 2
            },
            {
                "name": "gloves",
                "cnt": 4
            }
        ]
    }
}
```


### 주문 목록 조회 API
```
GET http://localhot:8080/api/orders
```
```json
// response
{
    "httpStatus": "OK",
    "body": [
        {
            "id": 1,
            "orderStatus": "CREATED",
            "orderItems": [
                {
                    "name": "jeans",
                    "cnt": 2
                },
                {
                    "name": "gloves",
                    "cnt": 4
                }
            ]
        }
    ]
}
```


## Entity
### Order
- 주문 엔티티입니다. 주문하려는 OrderItem을 담는 List를 포함하고 있으며 1:N 으로 양방향 연관관계로 매핑하였습니다.
- 주문 상태는 CREATED(생성), ACCEPTED(접수), COMPLETED(완료)를 포함하고 있습니다.

### OrderItem
- 어떤 상품이 주문될지에 대한 OrderItem Entity 객체입니다. 각 주문은 여러 개의 상품을 주문할 수 있기 때문에 이와 같이 설계 했습니다.
- Order와 양방향 관계를 가지고 있는 이유는 비지니스적인 관점에서 봤을 때 OrderItem(주문된 상품)에 대한 객체도 어떤 Order에 의해 주문이 되었는지 조회할 수 있어야 하기 때문입니다.
- Item 객체를 통해서(OrderItem과 N:1 단방향) 더 자세히 설계하면 좋겠지만,요구사항에서는 딱히 중요하지 않은 부분이라 Item객체를 생략하였습니다.

## 기타
### 공통 응답,에러 처리
- 공통 응답 처리는 ResponseEntity를 이용해 만들어둔 ResponseResult 객체를 넘겨주었습니다.
- 공통 에러는 @RsetControllerAdvice를 통해 처리해주었으며, 추후 추가적인 커스텀 에러를 적용하기 위해 정의할 수 있는 enum 클래스를 만들어두었습니다.
