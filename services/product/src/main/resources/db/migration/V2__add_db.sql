    -- 1. Önce Kategoriyi oluşturuyoruz
    INSERT INTO category (id, name, description) 
    VALUES (nextval('category_seq'), 'Mechanical Watches', 'Premium Japanese mechanical timepieces');

    -- 2. Ürünü ekliyoruz ve kategori_id olarak yukarıda oluşan ID'yi otomatik alıyoruz
    INSERT INTO product (id, name, description, available_quantity, price, category_id) 
    VALUES (
        nextval('product_seq'), 
        'Citizen Tsuyosa NJ0150-81X', 
        'Pantone Purple Dial, Sapphire Crystal, Automatic Miyota 8210', 
        10.0, 
        9500.00, 
        (SELECT currval('category_seq')) -- Burası dinamik oldu, asla hata vermez!
    );

