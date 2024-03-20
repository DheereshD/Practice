package com.surya.training.kotlin.collections

// products
val idea: Product = Product("IntelliJ IDEA Ultimate", 199.0)
val reSharper: Product = Product("ReSharper", 149.0)
val dotTrace: Product = Product("DotTrace", 159.0)
val dotMemory: Product = Product("DotMemory", 129.0)
val dotCover: Product = Product("DotCover", 99.0)
val appCode: Product = Product("AppCode", 99.0)
val phpStorm: Product = Product("PhpStorm", 99.0)
val pyCharm: Product = Product("PyCharm", 99.0)
val rubyMine: Product = Product("RubyMine", 99.0)
val webStorm: Product = Product("WebStorm", 49.0)
val teamCity: Product = Product("TeamCity", 299.0)
val youTrack: Product = Product("YouTrack", 500.0)

// customers
const val lucas: String = "Lucas"
const val cooper: String = "Cooper"
const val nathan: String = "Nathan"
const val reka: String = "Reka"
const val bajram: String = "Bajram"
const val asuka: String = "Asuka"
const val riku: String = "Riku"

// cities
val Canberra: City = City("Canberra")
val Vancouver: City = City("Vancouver")
val Budapest: City = City("Budapest")
val Ankara: City = City("Ankara")
val Tokyo: City = City("Tokyo")

fun customer(name: String, city: City, vararg orders: Order): Customer = Customer(name, city, orders.toList())
fun order(vararg products: Product, isDelivered: Boolean = true): Order = Order(products.toList(), isDelivered)
fun shop(name: String, vararg customers: Customer): Shop = Shop(name, customers.toList())

val shop: Shop = shop(
    "jb test shop",
    customer(
        lucas,
        Canberra,
        order(reSharper),
        order(reSharper, dotMemory, dotTrace),
    ),
    customer(cooper, Canberra),
    customer(
        nathan,
        Vancouver,
        order(rubyMine, webStorm),
    ),
    customer(
        reka,
        Budapest,
        order(idea, isDelivered = false),
        order(idea, isDelivered = false),
        order(idea),
    ),
    customer(
        bajram,
        Ankara,
        order(reSharper),
    ),
    customer(
        asuka,
        Tokyo,
        order(idea),
    ),
    customer(
        riku,
        Tokyo,
        order(phpStorm, phpStorm),
        order(phpStorm),
    ),

)

val customers: Map<String, Customer> = shop.customers.fold(hashMapOf()) { map, customer ->
    map[customer.name] = customer
    map
}

val orderedProducts: Set<Product> = setOf(idea, reSharper, dotTrace, dotMemory, rubyMine, webStorm, phpStorm)

val sortedCustomers: List<Customer?> = listOf(cooper, nathan, bajram, asuka, lucas, riku, reka).map { customers[it] }

val groupedByCities: Map<City, List<Customer?>> = mapOf(
    Canberra to listOf(lucas, cooper),
    Vancouver to listOf(nathan),
    Budapest to listOf(reka),
    Ankara to listOf(bajram),
    Tokyo to listOf(asuka, riku),
).mapValues { it.value.map { name -> customers[name] } }
