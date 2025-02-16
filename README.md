# JavaE-commerce SpringProject with REST API

here are some request User able to run it's local machine to for practice and run methods their local machine


Request#1
Get --> http://localhost:8080/api/v1/public/categories

Output          Status:- 400 Bad request
{
    "message": "No categories found.",
    "status": false
}

Request#2
Post --> http://localhost:8080/api/v1/admin/createcategory

    {
        "categoryName": "Floor",
        "categorytype": "grossary-item",
        "categoryrate": 2
    }

Output          Status:- 201 Created
{
    "categoryId": 1,
    "categoryName": "Floor",
    "categorytype": "grossary-item",
    "categoryrate": 2
}

Request#3
Post --> http://localhost:8080/api/v1/admin/createcategories

Output          Status:- 201 Created

   [
    {
        "categoryName": "Mens T-Shirts",
        "categoryrate": 5,
        "categorytype": "Clothing"
    },
    {
        "categoryName": "Smartphones",
        "categoryrate": 5,
        "categorytype": "Electronics"
    },
    {
        "categoryName": "Apparel",
        "categoryrate": 4,
        "categorytype": "Clothing"
    },
    {
        "categoryName": "Home Appliances",
        "categoryrate": 5,
        "categorytype": "Electronics"
    },
    {
        "categoryName": "Toys",
        "categoryrate": 4,
        "categorytype": "Entertainment"
    },
    {
        "categoryName": "Furniture",
        "categoryrate": 5,
        "categorytype": "Home & Living"
    },
    {
        "categoryName": "Books",
        "categoryrate": 5,
        "categorytype": "Education"
    },
    {
        "categoryName": "Sports Equipment",
        "categoryrate": 4,
        "categorytype": "Sports"
    },
    {
        "categoryName": "Beauty Products",
        "categoryrate": 5,
        "categorytype": "Personal Care"
    },
    {
        "categoryName": "Automotive",
        "categoryrate": 5,
        "categorytype": "Vehicles"
    },
    {
        "categoryName": "Outdoor Gear",
        "categoryrate": 4,
        "categorytype": "Adventure"
    },
    {
        "categoryName": "Electronics",
        "categoryrate": 5,
        "categorytype": "Technology"
    },
    {
        "categoryName": "Kitchen Appliances",
        "categoryrate": 5,
        "categorytype": "Home & Living"
    },
    {
        "categoryName": "Baby Products",
        "categoryrate": 5,
        "categorytype": "Child Care"
    },
    {
        "categoryName": "Health & Fitness",
        "categoryrate": 5,
        "categorytype": "Wellness"
    },
    {
        "categoryName": "Garden & Outdoor",
        "categoryrate": 4,
        "categorytype": "Home Improvement"
    },
    {
        "categoryName": "Pet Supplies",
        "categoryrate": 4,
        "categorytype": "Pets"
    },
    {
        "categoryName": "Office Supplies",
        "categoryrate": 4,
        "categorytype": "Business"
    },
    {
        "categoryName": "Jewelry & Watches",
        "categoryrate": 5,
        "categorytype": "Fashion"
    },
    {
        "categoryName": "Travel & Luggage",
        "categoryrate": 5,
        "categorytype": "Lifestyle"
    },
    {
        "categoryName": "Musical Instruments",
        "categoryrate": 4,
        "categorytype": "Entertainment"
    },
    {
        "categoryName": "Crafts & Hobbies",
        "categoryrate": 4,
        "categorytype": "DIY"
    },
    {
        "categoryName": "Collectibles & Memorabilia",
        "categoryrate": 4,
        "categorytype": "Antiques"
    },
    {
        "categoryName": "Art & Decor",
        "categoryrate": 5,
        "categorytype": "Home & Living"
    },
    {
        "categoryName": "Food & Beverages",
        "categoryrate": 5,
        "categorytype": "Grocery"
    },
    {
        "categoryName": "Stationery & Gift Wrapping",
        "categoryrate": 4,
        "categorytype": "Office"
    },
    {
        "categoryName": "Electrical & Lighting",
        "categoryrate": 5,
        "categorytype": "Home Improvement"
    },
    {
        "categoryName": "DIY & Tools",
        "categoryrate": 5,
        "categorytype": "Home Improvement"
    },
    {
        "categoryName": "Party Supplies",
        "categoryrate": 4,
        "categorytype": "Entertainment"
    },
    {
        "categoryName": "Educational Toys",
        "categoryrate": 5,
        "categorytype": "Education"
    }
]

Output          Status:- 201 Created
[
    {
        "categoryId": 1,
        "categoryName": "Mens T-Shirts",
        "categorytype": "Clothing",
        "categoryrate": 5
    },
    {
        "categoryId": 2,
        "categoryName": "Smartphones",
        "categorytype": "Electronics",
        "categoryrate": 5
    },
    {
        "categoryId": 3,
        "categoryName": "Apparel",
        "categorytype": "Clothing",
        "categoryrate": 4
    },
    {
        "categoryId": 4,
        "categoryName": "Home Appliances",
        "categorytype": "Electronics",
        "categoryrate": 5
    },
    {
        "categoryId": 5,
        "categoryName": "Toys",
        "categorytype": "Entertainment",
        "categoryrate": 4
    },
    {
        "categoryId": 6,
        "categoryName": "Furniture",
        "categorytype": "Home & Living",
        "categoryrate": 5
    },
    {
        "categoryId": 7,
        "categoryName": "Books",
        "categorytype": "Education",
        "categoryrate": 5
    },
    {
        "categoryId": 8,
        "categoryName": "Sports Equipment",
        "categorytype": "Sports",
        "categoryrate": 4
    },
    {
        "categoryId": 9,
        "categoryName": "Beauty Products",
        "categorytype": "Personal Care",
        "categoryrate": 5
    },
    {
        "categoryId": 10,
        "categoryName": "Automotive",
        "categorytype": "Vehicles",
        "categoryrate": 5
    },
    {
        "categoryId": 11,
        "categoryName": "Outdoor Gear",
        "categorytype": "Adventure",
        "categoryrate": 4
    },
    {
        "categoryId": 12,
        "categoryName": "Electronics",
        "categorytype": "Technology",
        "categoryrate": 5
    },
    {
        "categoryId": 13,
        "categoryName": "Kitchen Appliances",
        "categorytype": "Home & Living",
        "categoryrate": 5
    },
    {
        "categoryId": 14,
        "categoryName": "Baby Products",
        "categorytype": "Child Care",
        "categoryrate": 5
    },
    {
        "categoryId": 15,
        "categoryName": "Health & Fitness",
        "categorytype": "Wellness",
        "categoryrate": 5
    },
    {
        "categoryId": 16,
        "categoryName": "Garden & Outdoor",
        "categorytype": "Home Improvement",
        "categoryrate": 4
    },
    {
        "categoryId": 17,
        "categoryName": "Pet Supplies",
        "categorytype": "Pets",
        "categoryrate": 4
    },
    {
        "categoryId": 18,
        "categoryName": "Office Supplies",
        "categorytype": "Business",
        "categoryrate": 4
    },
    {
        "categoryId": 19,
        "categoryName": "Jewelry & Watches",
        "categorytype": "Fashion",
        "categoryrate": 5
    },
    {
        "categoryId": 20,
        "categoryName": "Travel & Luggage",
        "categorytype": "Lifestyle",
        "categoryrate": 5
    },
    {
        "categoryId": 21,
        "categoryName": "Musical Instruments",
        "categorytype": "Entertainment",
        "categoryrate": 4
    },
    {
        "categoryId": 22,
        "categoryName": "Crafts & Hobbies",
        "categorytype": "DIY",
        "categoryrate": 4
    },
    {
        "categoryId": 23,
        "categoryName": "Collectibles & Memorabilia",
        "categorytype": "Antiques",
        "categoryrate": 4
    },
    {
        "categoryId": 24,
        "categoryName": "Art & Decor",
        "categorytype": "Home & Living",
        "categoryrate": 5
    },
    {
        "categoryId": 25,
        "categoryName": "Food & Beverages",
        "categorytype": "Grocery",
        "categoryrate": 5
    },
    {
        "categoryId": 26,
        "categoryName": "Stationery & Gift Wrapping",
        "categorytype": "Office",
        "categoryrate": 4
    },
    {
        "categoryId": 27,
        "categoryName": "Electrical & Lighting",
        "categorytype": "Home Improvement",
        "categoryrate": 5
    },
    {
        "categoryId": 28,
        "categoryName": "DIY & Tools",
        "categorytype": "Home Improvement",
        "categoryrate": 5
    },
    {
        "categoryId": 29,
        "categoryName": "Party Supplies",
        "categorytype": "Entertainment",
        "categoryrate": 4
    },
    {
        "categoryId": 30,
        "categoryName": "Educational Toys",
        "categorytype": "Education",
        "categoryrate": 5
    }
]

Request#4
Get --> http://localhost:8080/api/v1/public/categories

Output          Status:- 200 Ok

{
    "content": [
        {
            "categoryId": 1,
            "categoryName": "Mens T-Shirts",
            "categorytype": "Clothing",
            "categoryrate": 5
        },
        {
            "categoryId": 2,
            "categoryName": "Smartphones",
            "categorytype": "Electronics",
            "categoryrate": 5
        },
        {
            "categoryId": 3,
            "categoryName": "Apparel",
            "categorytype": "Clothing",
            "categoryrate": 4
        },
        {
            "categoryId": 4,
            "categoryName": "Home Appliances",
            "categorytype": "Electronics",
            "categoryrate": 5
        },
        {
            "categoryId": 5,
            "categoryName": "Toys",
            "categorytype": "Entertainment",
            "categoryrate": 4
        },
        {
            "categoryId": 6,
            "categoryName": "Furniture",
            "categorytype": "Home & Living",
            "categoryrate": 5
        },
        {
            "categoryId": 7,
            "categoryName": "Books",
            "categorytype": "Education",
            "categoryrate": 5
        },
        {
            "categoryId": 8,
            "categoryName": "Sports Equipment",
            "categorytype": "Sports",
            "categoryrate": 4
        },
        {
            "categoryId": 9,
            "categoryName": "Beauty Products",
            "categorytype": "Personal Care",
            "categoryrate": 5
        },
        {
            "categoryId": 10,
            "categoryName": "Automotive",
            "categorytype": "Vehicles",
            "categoryrate": 5
        },
        {
            "categoryId": 11,
            "categoryName": "Outdoor Gear",
            "categorytype": "Adventure",
            "categoryrate": 4
        },
        {
            "categoryId": 12,
            "categoryName": "Electronics",
            "categorytype": "Technology",
            "categoryrate": 5
        },
        {
            "categoryId": 13,
            "categoryName": "Kitchen Appliances",
            "categorytype": "Home & Living",
            "categoryrate": 5
        },
        {
            "categoryId": 14,
            "categoryName": "Baby Products",
            "categorytype": "Child Care",
            "categoryrate": 5
        },
        {
            "categoryId": 15,
            "categoryName": "Health & Fitness",
            "categorytype": "Wellness",
            "categoryrate": 5
        },
        {
            "categoryId": 16,
            "categoryName": "Garden & Outdoor",
            "categorytype": "Home Improvement",
            "categoryrate": 4
        },
        {
            "categoryId": 17,
            "categoryName": "Pet Supplies",
            "categorytype": "Pets",
            "categoryrate": 4
        },
        {
            "categoryId": 18,
            "categoryName": "Office Supplies",
            "categorytype": "Business",
            "categoryrate": 4
        },
        {
            "categoryId": 19,
            "categoryName": "Jewelry & Watches",
            "categorytype": "Fashion",
            "categoryrate": 5
        },
        {
            "categoryId": 20,
            "categoryName": "Travel & Luggage",
            "categorytype": "Lifestyle",
            "categoryrate": 5
        },
        {
            "categoryId": 21,
            "categoryName": "Musical Instruments",
            "categorytype": "Entertainment",
            "categoryrate": 4
        },
        {
            "categoryId": 22,
            "categoryName": "Crafts & Hobbies",
            "categorytype": "DIY",
            "categoryrate": 4
        },
        {
            "categoryId": 23,
            "categoryName": "Collectibles & Memorabilia",
            "categorytype": "Antiques",
            "categoryrate": 4
        },
        {
            "categoryId": 24,
            "categoryName": "Art & Decor",
            "categorytype": "Home & Living",
            "categoryrate": 5
        },
        {
            "categoryId": 25,
            "categoryName": "Food & Beverages",
            "categorytype": "Grocery",
            "categoryrate": 5
        },
        {
            "categoryId": 26,
            "categoryName": "Stationery & Gift Wrapping",
            "categorytype": "Office",
            "categoryrate": 4
        },
        {
            "categoryId": 27,
            "categoryName": "Electrical & Lighting",
            "categorytype": "Home Improvement",
            "categoryrate": 5
        },
        {
            "categoryId": 28,
            "categoryName": "DIY & Tools",
            "categorytype": "Home Improvement",
            "categoryrate": 5
        },
        {
            "categoryId": 29,
            "categoryName": "Party Supplies",
            "categorytype": "Entertainment",
            "categoryrate": 4
        },
        {
            "categoryId": 30,
            "categoryName": "Educational Toys",
            "categorytype": "Education",
            "categoryrate": 5
        }
    ]
}

Request#5
put --> http://localhost:8080/api/v1/admin/putcategories/345

Output          Status:- 404 Not Found

{
    "message": "Category not found with categoryId: 345",
    "status": false
}

Request#6
put --> http://localhost:8080/api/v1/admin/deletecategory/357

Output          Status:- 404 Not Found

{
    "message": "Category not found with categoryId: 357",
    "status": false
}

Request#7

Post --> http://localhost:8080/api/v1/admin/createcategory

    {
        "categoryName": "Floor",
        "categorytype": "grossary-item",
        "categoryrate": 
    }

Output          Status:- 400 Bad Request

{
    "error": "Invalid JSON format",
    "message": "Check your JSON structure and ensure all required fields are provided."
}

Request#8

Delete--> http://localhost:8080/api/v1/admin/deletecategory/3
Output          Status:- 200 Ok
   {
    "categoryId": 3,
    "categoryName": "Apparel",
    "categorytype": "Clothing",
    "categoryrate": 4
  }

Request#9

put--> http://localhost:8080/api/v1/admin/putcategories/4
Output          Status:- 200 Ok
  {
    "categoryId": 4,
    "categoryName": "Biscuit",
    "categorytype": "Food-item",
    "categoryrate": 120
}

Request#10
Get--> http://localhost:8080/api/v1/public/categories?pageNumber=0&pageSize=10&sortBy=categorytype&sortOrder=desc



Output          Status:- 200 Ok

{
    "content": [
        {
            "categoryId": 1,
            "categoryName": "Mens T-Shirts",
            "categorytype": "Clothing",
            "categoryrate": 5
        },
        {
            "categoryId": 2,
            "categoryName": "Smartphones",
            "categorytype": "Electronics",
            "categoryrate": 5
        },
        {
            "categoryId": 3,
            "categoryName": "Apparel",
            "categorytype": "Clothing",
            "categoryrate": 4
        },
        {
            "categoryId": 4,
            "categoryName": "Home Appliances",
            "categorytype": "Electronics",
            "categoryrate": 5
        },
        {
            "categoryId": 5,
            "categoryName": "Toys",
            "categorytype": "Entertainment",
            "categoryrate": 4
        },
        {
            "categoryId": 6,
            "categoryName": "Furniture",
            "categorytype": "Home & Living",
            "categoryrate": 5
        },
        {
            "categoryId": 7,
            "categoryName": "Books",
            "categorytype": "Education",
            "categoryrate": 5
        },
        {
            "categoryId": 8,
            "categoryName": "Sports Equipment",
            "categorytype": "Sports",
            "categoryrate": 4
        },
        {
            "categoryId": 9,
            "categoryName": "Beauty Products",
            "categorytype": "Personal Care",
            "categoryrate": 5
        },
        {
            "categoryId": 10,
            "categoryName": "Automotive",
            "categorytype": "Vehicles",
            "categoryrate": 5
        },
        {
            "categoryId": 11,
            "categoryName": "Outdoor Gear",
            "categorytype": "Adventure",
            "categoryrate": 4
        },
        {
            "categoryId": 12,
            "categoryName": "Electronics",
            "categorytype": "Technology",
            "categoryrate": 5
        },
        {
            "categoryId": 13,
            "categoryName": "Kitchen Appliances",
            "categorytype": "Home & Living",
            "categoryrate": 5
        },
        {
            "categoryId": 14,
            "categoryName": "Baby Products",
            "categorytype": "Child Care",
            "categoryrate": 5
        },
        {
            "categoryId": 15,
            "categoryName": "Health & Fitness",
            "categorytype": "Wellness",
            "categoryrate": 5
        },
        {
            "categoryId": 16,
            "categoryName": "Garden & Outdoor",
            "categorytype": "Home Improvement",
            "categoryrate": 4
        },
        {
            "categoryId": 17,
            "categoryName": "Pet Supplies",
            "categorytype": "Pets",
            "categoryrate": 4
        },
        {
            "categoryId": 18,
            "categoryName": "Office Supplies",
            "categorytype": "Business",
            "categoryrate": 4
        },
        {
            "categoryId": 19,
            "categoryName": "Jewelry & Watches",
            "categorytype": "Fashion",
            "categoryrate": 5
        },
        {
            "categoryId": 20,
            "categoryName": "Travel & Luggage",
            "categorytype": "Lifestyle",
            "categoryrate": 5
        },
        {
            "categoryId": 21,
            "categoryName": "Musical Instruments",
            "categorytype": "Entertainment",
            "categoryrate": 4
        },
        {
            "categoryId": 22,
            "categoryName": "Crafts & Hobbies",
            "categorytype": "DIY",
            "categoryrate": 4
        },
        {
            "categoryId": 23,
            "categoryName": "Collectibles & Memorabilia",
            "categorytype": "Antiques",
            "categoryrate": 4
        },
        {
            "categoryId": 24,
            "categoryName": "Art & Decor",
            "categorytype": "Home & Living",
            "categoryrate": 5
        },
        {
            "categoryId": 25,
            "categoryName": "Food & Beverages",
            "categorytype": "Grocery",
            "categoryrate": 5
        },
        {
            "categoryId": 26,
            "categoryName": "Stationery & Gift Wrapping",
            "categorytype": "Office",
            "categoryrate": 4
        },
        {
            "categoryId": 27,
            "categoryName": "Electrical & Lighting",
            "categorytype": "Home Improvement",
            "categoryrate": 5
        },
        {
            "categoryId": 28,
            "categoryName": "DIY & Tools",
            "categorytype": "Home Improvement",
            "categoryrate": 5
        },
        {
            "categoryId": 29,
            "categoryName": "Party Supplies",
            "categorytype": "Entertainment",
            "categoryrate": 4
        },
        {
            "categoryId": 30,
            "categoryName": "Educational Toys",
            "categorytype": "Education",
            "categoryrate": 5
        }
    ],
    "pageNumber": 0,
    "pageSize": 50,
    "totalPages": 1,
    "totalElements": 30,
    "lastPage": true,
    "version": 1
}
