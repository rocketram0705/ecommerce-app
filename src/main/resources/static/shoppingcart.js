var shoppingCart = new Array();
var addToCartButtons = document.getElementsByClassName("fa-solid fa-cart-plus float");
for (let i=0;i<addToCartButtons.length;i++){
    var addToCartButton=addToCartButtons[i];
    addToCartButton.addEventListener("click",addToCart);
}
function addToCart(event){
var addToCartButtonClicked = event.target;
var description =addToCartButtonClicked.parentElement; 
var product = description.parentElement;
var productPriceContainer = description.children[1];
var imageContainer = product.children[0];
var productName = description.children[0].innerText;
var productPrice = productPriceContainer.children[0].innerText;
var imageSource = imageContainer.children[0].src;
var cartProduct = new Object();
cartProduct.name = productName; 
cartProduct.price= productPrice;
cartProduct.image = imageSource;
shoppingCart.push(cartProduct);
alert("added to array.....");
localStorage.setItem("products",JSON.stringify(shoppingCart));
}

//adding the array items to the cart.html page...
function getAddToCartItems(){
    var storedItems = JSON.parse(localStorage.getItem("products"));
    console.log("this is array from local storage" +storedItems.length);
    for (let i = 0; i < storedItems.length; i++) {
        console.log(storedItems[i]);   
    }
    var mainContainer = document.getElementById("CartItemContainer");
    for (let i = 0; i<storedItems.length; i++) {
        var cartItemCont = document.createElement("div");
        cartItemCont.className="cart-item";
        var productname = storedItems[i].name;
        var priceamount= storedItems[i].price;
        var productImage = storedItems[i].image;
        var productInnerHtml = `<div class="productCls"><div class="imgcontainer"><img src=${productImage}alt="shirt">/img> </div><div class="des"><h5>${productname}</h5><span class="price">price:<label class="amount">${priceamount}</label></span><span class="stock">stock(in Nos):<label class="count">5</label></span></div></div><div class="cartCls"><div class="quantityCont"><label for="" class="labelcls">Quantity</label><input type="number" class="count"></div><div class="subtotalCls"><label class="labelcls">subtotal</label><label class="subtotal">$100.55</label></div><button type="button" class="btn btn-primary" style="background-color:red;color: white;position:absolute;bottom:0px;right:4%;padding:0.5%;">remove</button></div>`;
        cartItemCont.innerHTML = productInnerHtml;
        mainContainer.appendChild(cartItemCont); 
    }
}

function clearLocalStorage(){
    localStorage.clear();
    window.location.reload();
}