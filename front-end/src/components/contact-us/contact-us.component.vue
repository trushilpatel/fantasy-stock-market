<template>
  <div id="contact-us" class="container-fluid">
    <div class="row" >
      <form
        v-on:submit.prevent="submi"
        class="col-md-6 ml-auto mr-auto my-5 border py-5 px-4 shadow bg-dark text-white"
      >
        <div class="display-4 border-bottom pb-2 mb-4 ">Contact Us</div>
        <div class="input-group my-3">
          <div class="input-group-text  rounded-0 border-right border-0 ">Name</div>
          <input type="text" name="name" id="" class="form-control border-0 rounded-0" >
        </div>
        <div class="input-group my-3">
          <div class="input-group-text  rounded-0 border-right border-0 ">Email</div>
          <input type="text" name="name" id="" class="form-control border-0 rounded-0" >
        </div>
        <div class="input-group my-3 flex flex-column">
          <div class="input-group-text  rounded-0 border-right border-0">Subject</div>
          <textarea type="text" name="name" id="" class=" border-0 rounded-0" cols="20" rows="3"></textarea>
        </div>

        <div class="row pt-4">
          <button type="submit" class="btn px-5 border-0 rounded-0 bg-white ml-auto mr-auto">Submit</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script src='./contact-us.component.js' />
<style src='./contact-us.component.css' />
