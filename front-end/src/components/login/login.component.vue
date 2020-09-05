<template>
  <div id="login" class="container-fluid">
    <div class=" pt-md-5">
      <form
        v-on:submit.prevent="submit()"
        class="col-md-5 ml-auto mr-auto border border-dark p-4 shadow mt-auto mb-auto"
      >
        <div class=" text-center font-weight-bolder">
          <div class="border-bottom border-dark lead display-4 ">FSM</div>
            <span class="lead">
              Sign in to continue...
            </span>
        </div>
        <div class="my-4">
          <div class="form-group mt-5 border p-3 border-dark shadow-lg">
            <div class="input-group my-3">
              <span class="input-group-text bg-dark text-white border-dark border-0 rounded-0">
                E-mail
              </span>
              <input type="email" name="email" class="form-control  text-white border-dark bg-gray border-0 rounded-0" />
            </div>
            <div class="input-group my-4">
              <span class="input-group-text bg-dark text-white border-dark border-right-0 border-0 rounded-0">
                Password
              </span>
              <input type="password" name="password" class="form-control text-white border-dark bg-gray border-0 rounded-0" />
            </div>
            <div class="mt-4 mb-4">
              <button type="submit" class="form-control btn btn-block btn-primary ml-auto mr-auto px-0 border-0 rounded-0">
                Sign In
              </button>
            </div>
          </div>
        </div>

        <div class=" my-3 ">
          <button type="submit" class="btn btn-block btn-success border-0 rounded-0">
            Create New Account
          </button>

          <button type="submit" class="btn btn-block btn-danger border-0 rounded-0 ">
            Sign In With Google
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script src="./login.component.js"></script>

<style src="./login.component.css" scoped></style>
