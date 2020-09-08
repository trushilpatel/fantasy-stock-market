<template>
  <div id="contact-us" class="container-fluid">
    <Message
      v-if="message !== ''"
      v-bind:message="message"
      v-on:close="message = ''"
    >
    </Message>
    <div class="row">
      <form
        v-on:submit.prevent="submit"
        class="col-md-6 ml-auto mr-auto my-5 border py-5 px-4 shadow bg-dark text-white"
      >
        <div class="display-4 border-bottom pb-2 mb-4 ">Contact Us</div>
        <div class="input-group my-3">
          <div class="input-group-text  rounded-0 border-right border-0 ">
            Name
          </div>
          <input
            v-model="name"
            v-on:blur="$v.name.$touch()"
            type="text"
            name="name"
            id=""
            class="form-control border-0 rounded-0"
          />
        </div>
        <div
          v-if="$v.name.$dirty && $v.name.$invalid"
          class="col-md-6 ml-auto mr-auto lead text-danger small"
        >
          * Please Enter Valid Name...
        </div>
        <div class="input-group my-3">
          <div class="input-group-text  rounded-0 border-right border-0 ">
            Email
          </div>
          <input
            v-model="email"
            v-on:blur="$v.email.$touch()"
            type="text"
            name="email"
            id=""
            class="form-control border-0 rounded-0"
          />
        </div>
        <div
          v-if="$v.email.$dirty && $v.email.$invalid"
          class="col-md-6 ml-auto mr-auto lead text-danger small"
        >
          * Please Enter Valid Email Address...
        </div>
        <div class="input-group my-3 flex flex-column">
          <div class="input-group-text  rounded-0 border-right border-0">
            Subject
          </div>
          <textarea
            v-model="subject"
            v-on:blur="$v.subject.$touch()"
            type="text"
            name="subject"
            id=""
            class=" border-0 rounded-0"
            cols="20"
            rows="3"
          ></textarea>
        </div>
        <div
          v-if="$v.subject.$dirty && $v.subject.$invalid"
          class="col-md-6 ml-auto mr-auto lead text-danger small"
        >
          * Subject must atleast 20 character long...
        </div>

        <div class="row pt-4">
          <button
            type="submit"
            class="btn px-5 border-0 rounded-0 bg-white ml-auto mr-auto"
          >
            Submit
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script src="./contact-us.component.js" />
<style src="./contact-us.component.css" />
