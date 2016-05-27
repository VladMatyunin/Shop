//Удаление товара
function deleteProduct(id) {
    $.ajax({
        url: "/cart/deleteProduct",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            window.location.href = "/cart/get";
            // alert('Удалено');
            return true;
        }
    })
}
// Изменение количества 
function changeNumberProduct(id) {
    var numberProduct = $('#numberProduct' + id).val();
    if (numberProduct > 0 && numberProduct < 16) {
        $.ajax({
            url: "/cart/changeNumber",
            type: "POST",
            data: {
                id: id,
                number: numberProduct
            },
            success: function () {
                alert('Изменено');
                return true;
            }
        })
    }else alert('Количество может быть от 1 до 15');
}

function buyProducts() {
    $.ajax({
        url: "/cart/buy",
        type: "POST",
        success: function () {
            alert('Оформлено');
            window.location.href = "/cabinet/orders";
            return true;
        }
    })
}
