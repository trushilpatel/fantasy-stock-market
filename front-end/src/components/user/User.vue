<template>
  <div>
    <router-view v-on:message="$emit('message', $event)" class="pt-5"></router-view>
  </div>
</template>

<script>
export default {}
</script>

<style scoped></style>
