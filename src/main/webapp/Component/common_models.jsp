
<!-- Modal -->
<div class="modal fade" id="cart" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Your Cart</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <div class="cart-body">
              
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary checkout-btn" onclick="goToCheckout()">Checkout</button>
      </div>
    </div>
  </div>
</div>

<div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="toast-header">
    <!--<img src="..." class="rounded me-2" alt="...">-->
    <!--<strong class="me-auto">Bootstrap</strong>-->
    <!--<small class="text-muted">11 mins ago</small>-->
    <button onclick="showToast" type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
  </div>
    <div class="toast-body" id="toast">
    Hello, world! This is a toast message.
  </div>
</div>

