<template>
  <transition v-if="showModal" name="modal">
    <div class="modal-mask text-dark">
      <div class="modal-wrapper ">
        <div class="modal-container ml-auto mr-auto shadow-lg">
          <div class="text-center border-bottom py-4 mb-3 font-weight-bold text-lg">
              {{ message.title }}
          </div>

          <div class="text-center my-4">
            {{ message.body }}
          </div>

          <div class="modal-footer">
            <button class="btn btn-primary px-5 my-3 ml-auto mr-auto " @click="$emit('close')">
              OK
            </button>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script src="./Message.component.js" />
<style src="./Message.component.css" />
