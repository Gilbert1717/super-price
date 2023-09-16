// CheckoutPage.js
import React from 'react';

function CheckoutPage() {
    return (
        <div className="CheckOutContainer">
            <form action="">
                <div className="row">
                    <div className="col">
                        <h3 className="title">billing address</h3>

                        <div className="inputBox">
                            <span>full name :</span>
                            <input type="text" placeholder="Steve Smith" />
                        </div>
                        <div className="inputBox">
                            <span>email :</span>
                            <input type="text" placeholder="stevesmith@gmail.com" />
                        </div>
                        <div className="inputBox">
                            <span>address :</span>
                            <input type="text" placeholder="Room - Street - Locality" />
                        </div>
                        <div className="inputBox">
                            <span>city :</span>
                            <input type="text" placeholder="Melbourne" />
                        </div>

                        <div className="flex">
                            <div className="inputBox">
                                <span>state :</span>
                                <input type="text" placeholder="VIC" />
                            </div>
                            <div className="inputBox">
                                <span>zip code :</span>
                                <input type="text" placeholder="123 456" />
                            </div>
                        </div>
                    </div>

                    <div className="col">
                        <h3 className="title">payment</h3>

                        <div className="inputBox">
                            <span>Delivery Date :</span>
                            <input type="date" placeholder="DD/MM/YYYY"/>
                        </div>
                        <div className="inputBox">
                            <span>name on card :</span>
                            <input type="text" placeholder="Mr. Steve Smith" />
                        </div>
                        <div className="inputBox">
                            <span>credit card number :</span>
                            <input type="number" placeholder="1111-2222-3333-4444" />
                        </div>
                        <div className="inputBox">
                            <span>exp month :</span>
                            <input type="text" placeholder="January" />
                        </div>

                        <div className="flex">
                            <div className="inputBox">
                                <span>exp year :</span>
                                <input type="number" placeholder="2022" />
                            </div>
                            <div className="inputBox">
                                <span>CVV :</span>
                                <input type="text" placeholder="123" />
                            </div>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Place Order" class="submit-btn"/>
            </form>
        </div>
    );
}

export default CheckoutPage;
