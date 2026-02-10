erDiagram
    CUSTOMER ||--o{ PAYMENT_METHOD : "stores"
    CUSTOMER ||--o{ PAYMENT_TRANSACTION : "initiates"
    PAYMENT_TRANSACTION ||--o{ TRANSACTION_ATTEMPT : "triggers"

    CUSTOMER {
        uuid id PK
        string email
        string status
        timestamp created_at
    }

    PAYMENT_METHOD {
        uuid id PK
        uuid customer_id FK
        string type "CARD, PAYPAL"
        string token
        string last4
    }

    PAYMENT_TRANSACTION {
        uuid id PK
        uuid customer_id FK
        decimal amount
        string currency
        string status "CREATED, PENDING, COMPLETED, FAILED"
        string idempotency_key UK
        timestamp created_at
    }

    TRANSACTION_ATTEMPT {
        uuid id PK
        uuid transaction_id FK
        string response_code
        string error_message
        boolean success
        timestamp created_at
    }