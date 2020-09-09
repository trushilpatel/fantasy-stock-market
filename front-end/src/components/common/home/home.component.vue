<template>
  <div id="home" class="container-fluid p-0">
    <header class="">
      <div class="darkOverLay pb-5">
        <div class="row text-white">
          <div class="pt-5 col-lg-4 col-8 font-weight-bold col-0  m-auto ">
            <img
              src="@/assets/FSM.png"
              alt=""
              class="img-fluid"
              height="300px"
              width="500px"
            />
          </div>
          <div class="col-lg-6 col-10 mr-auto ml-auto py-5">
            <ul class="display-4 fa-ul font-weight-bold ">
              <li
                class="py-4 display-3 font-weight-bold border-bottom mr-auto text-blue"
              >
                Learn The Stock Market For Free
              </li>
              <ul class="text-gray pt-5">
                <li class="py-4">Buy/Sell</li>
                <li class="py-4">Future Options</li>
                <li class="py-4">IPO</li>
              </ul>
            </ul>
          </div>
        </div>
        <div class="row">
          <div
            class="col-md-6 col-10 ml-auto mr-auto bg-dark border py-5 text-white text-center"
          >
            <div class=" col-10 ml-auto mr-auto display-4">
              Lets Get Started...
            </div>
            <div class="pt-4 col-10 ml-auto mr-auto text-center">
              <button
                class="m-3 btn btn-success border-0 rounded-0 px-5 mx-3"
                v-on:click="$router.push('/sign-in')"
              >
                Sign In
              </button>
              <button
                class="m-3 btn btn-danger border-0 rounded-0 px-5"
                v-on:click="$router.push('/sign-up')"
              >
                Sign Up
              </button>
            </div>
          </div>
        </div>
      </div>
    </header>
  </div>
</template>

<script src="./home.component.js"></script>
<style src="./home.component.css" scoped></style>
