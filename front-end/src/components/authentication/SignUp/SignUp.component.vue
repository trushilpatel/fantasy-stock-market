<template>
  <div id="sign-up" class="container-fluid pb-5">
    <div class=" pt-md-5">
      <form
        v-on:submit.prevent="submit()"
        class="col-md-5 ml-auto mr-auto shadow mt-auto mb-auto p-0"
      >
        <div class="bg-dark text-white py-3 text-center font-weight-bolder">
          <div class="lead display-4 ">
            <img
              src="@/assets/FSM.png"
              height="70rem"
              width="70rem"
              class="mr-3"
            />
            FSM
          </div>
        </div>

        <div class="my-4 mb-5 mx-5">
          <div class="form-group mt-5 pt-3 border-dark shadow-lg">
            <div class="input-group my-3 px-3">
              <span
                class="input-group-text bg-dark text-white border-dark border-0 rounded-0"
              >
                E-mail
              </span>
              <input
                v-model="email"
                v-on:blur="$v.email.$touch()"
                autocomplete="email"
                type="email"
                name="email"
                class="form-control  text-white border-dark bg-gray border-0 rounded-0"
              />
            </div>
            <div
              v-if="$v.email.$dirty && $v.email.$invalid"
              class=" ml-auto mr-auto lead text-danger small"
            >
              * Please enter valid email address...
            </div>
            <div class="input-group my-4 px-3">
              <span
                class="input-group-text bg-dark text-white border-dark border-right-0 border-0 rounded-0"
              >
                Password
              </span>
              <input
                v-model="password"
                v-on:blur="$v.password.$touch()"
                autocomplete="password"
                type="password"
                name="password"
                class="form-control text-white border-dark bg-gray border-0 rounded-0"
              />
            </div>
            <div
              v-if="$v.password.$dirty && $v.password.$invalid"
              class="ml-auto mr-auto lead text-danger small"
            >
              * Password must be 8 character long (should contain small
              alphabet, capital alphabet,one number)
            </div>
            <div class="input-group my-4 px-3">
              <span
                class="input-group-text bg-dark text-white border-dark border-right-0 border-0 rounded-0"
              >
                Confirm Password
              </span>
              <input
                v-model="confirmPassword"
                v-on:blur="$v.confirmPassword.$touch()"
                autocomplete="password"
                type="password"
                name="password"
                class="form-control text-white border-dark bg-gray border-0 rounded-0"
              />
            </div>
            <div
              v-if="$v.confirmPassword.$dirty && $v.confirmPassword.$invalid"
              class="ml-auto mr-auto lead text-danger small"
            >
              * Both Password must match...
            </div>
            <div class="mt-4 ">
              <button
                type="submit"
                class="py-3 btn btn-block btn-primary ml-auto mr-auto px-0 border-0 rounded-0"
              >
                Sign Up
              </button>
            </div>
          </div>
        </div>

        <div class=" mt-3 ">
          <button
            type="submit"
            class="py-3 btn btn-block btn-success border-0 rounded-0"
            v-on:click="$router.push('/sign-in')"
          >
            Sign In
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script src="./SignUp.component.js"></script>

<style src="./SignUp.component.css" scoped></style>
