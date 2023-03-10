![LoahyTree Logo](uploads/Loahy_logo_DEF_dark_RGB_Normaal.png)

# Loahy | 2023 | Novi Hogeschool | Eindopdracht Full Stack Developer

|                                            |                                                 |
|--------------------------------------------|-------------------------------------------------|
| ![Novi-Hogeschool](uploads/logo_novi2.png) | ![Spring-boot](uploads/spring_boot%20Klein.png) |

> Dit is de Backend voor mijn webapplicatie **Loahy**. Loahy zal als een begin Spring based Application versie zijn voor een hobby/project [LoahyTree](https://www.instagram.com/loahytree/). 
> [Springboot](https://spring.io/projects/spring-boot) wordt gebruikt voor het bouwen van de backend van de applicative.
> De bedoeling is deze in de toekomst uit te breiden tot een daadwerkelijke running applicatie.

[Github voor de FRONT-END van Loahy vind je hier]( https://github.com/guilhermodaguiar/Frontend-Project-Loahy-V3)

[Github voor de BACK-END van Loahy vind je hier]( https://github.com/guilhermodaguiar/Backend-Project-Loahy-V3)


## Applicatie starten

Voor het **clonen** van de repository voor Loahy wordt verwezen naar de links in [Github](https://github.com):

| Soort | URL                                                                |
|-------|--------------------------------------------------------------------|
| HTTPS | `https://github.com/guilhermodaguiar/Backend-Project-Loahy-V3.git` |
| SSH   | `git@github.com:guilhermodaguiar/Backend-Project-Loahy-V3.git`     |


## Map Guide
Hieronder staan de mappen structuur van Springboot [Spring](https://spring.io) met de kort uitleg waarvoor ze gebruikt worden. 

### Config
Hier bevinden zich alle configuratie van Spring Security. Versie 2.7.0 van spring-boot-starter-security wordt gekozen 
omdat je WebSecurityConfigurerAdapter nog kan gebruiken. Deze is in een hogere versie deprecated.

### Controllers

Hier zijn alle gebruikte controller layers:
- AboutBrandController
- AuthenticationController
- ContactRemarkController
- ExceptionController
- ImageController
- OrderController
- ProductController
- ShoppingCartController/ShoppingCartProductController
- UserController
- WishlistController/WishlistProductController

### Dtos
- AboutBrandDto/AboutBrandInputDto
- ContactRemarkDto
- OrderDto/OrderInputDto
- ProductDto/ProductInputDto
- ShoppingCartDto/ShoppingCartInputDto
- UserDto
- WishlistDto

### Exceptions
- AboutBrandNotFoundException
- BadRequestException
- ContactNotFoundException
- OrderNotFoundException
- ProductNotFoundException
- ShoppingCartNotFoundException
- UserNotFoundException
- WishlistNotFoundException

### Filter
JwtRequestFilter wordt gebruikt om de authenticatie en de daarmee samenhangende autorisatie af te handelen voordat
de HTTP request bij de AuthenticationController binnenkomt.

### Models
- AboutBrand
- Authority/AuthorityKey
- ContactRemark
- FileUploadResponse
- Order
- Product
- ShoppingCart
- ShoppingCartProduct/ShoppingCartKey
- User
- Wishlist
- WishlistProduct/WishlistProductKey

### Payload
- AuthenticationRequest
- AuthenticationResponse

### Repository
- AboutBrandRepository
- ContactRemarkRepository
- FileUploadResponseRepository
- OrderRepository
- ProductRepository
- ShoppingCartRepository
- ShopppingCartProductRepository
- UserRepository
- WishlistRepository
- WishlistProductRepository

### Service

- AboutBrandService
- ContactRemarkService
- CustomUserDetailService
- ImageService
- OrderService
- ProductService
- ShoppingCartService
- ShoppingCartProductService
- UserService
- WishlistProductService
- WishlistService

### Utils
JwtUtil wordt gebruikt om een *JWT*-token te cre??ren.

## Gebruikers & Rollen
De volgende gebruikers kunnen worden gebruikt om de applicatie te testen. In de database en **data.sql** bestand in de backend zijn nog andere users toegevoegd, maar ????n rol voor user is voor nu voldoende.
Een eigen **account** kan gemaakt worden om producten toe te voegen aan een *wishlist* of aan een *shopping cart*.

>#### ADMIN_ROLE
> - gebruikersnaam: admin@test.nl
> - wachtwoord: admin123
>
> #### USER_ROLE
> - gebruikersnaam: user@test.nl
> - wachtwoord: test123
> - 



