    
    INSERT INTO category (id, name, description) 
    VALUES (nextval('category_seq'), 'Mechanical Watches', 'Premium Japanese mechanical timepieces');

    INSERT INTO product (id, name, description, available_quantity, price, category_id) 
    VALUES (
        nextval('product_seq'), 
        'Rolex', 
        'Luxury watch', 
        10.0, 
        9500.00, 
        (select id from category where name = 'Mechanical Watches' limit 1)
    );

