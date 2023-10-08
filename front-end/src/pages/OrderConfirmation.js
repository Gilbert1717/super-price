import { naviagte, useNavigate, useParams } from 'react-router-dom';


function OrderConfirmation() {
  const { query } = useParams();
  const naviagte = useNavigate()


  return (
      <div className='order-confirmation'>
        <h1>Order Confirmed!</h1>
        <h2>Your Order ID is <em> {query}</em>.</h2>
        <p>
          You can use this number to see your order details.
          Click on 'View Orders', then enter your order ID.
        </p>
        <button className='return-home' onClick={()=>naviagte('/')}>Return to Homepage</button>
      </div>
    );
  }
  
  export default OrderConfirmation;
  