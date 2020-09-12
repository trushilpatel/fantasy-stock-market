<template>
  <div class="container-fluid py-5">
    <div class="display-4 text-center font-weight-bold bg-dark text-white py-3">
      Stock Market Analysis
    </div>
    <div id="chart">
      <template v-for="(value, key) in sectors">
        <div class="d-inline-block col-md-6 col-11" :key="key">
          <div
            class="border ml-auto mr-auto pb-5 p-0 text-center shadow my-5"
          >
            <div class="display-4 bg-dark text-white py-2 ">
              {{ key.slice(8).replace('Performance', '') }}
            </div>
            <pie-chart class="py-3" :data="value"></pie-chart>
          </div>
        </div>
      </template>
    </div>
  </div>
</template>

<script src="./UserHome.component.js" />
<style src="./UserHome.component.css" />
