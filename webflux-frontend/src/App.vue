<template>
  <el-container id="app">
    <el-header>
      <el-button @click="openConnection">打开连接</el-button>
      <el-button @click="closeConnection">关闭连接</el-button>
    </el-header>
    <el-main>
      <el-table :data="dataList" style="width=100%">
        <el-table-column prop="name" label="名称"></el-table-column>
        <el-table-column prop="description" label="简介"></el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "app",
  data: function() {
    return {
      source: null,
      dataList: []
    };
  },
  methods: {
    openConnection() {
      if (this.source !== null) {
        this.closeConnection();
      }
      this.source = new EventSource("http://localhost:8081/city");
      this.source.onmessage = (event) => {
        let obj = JSON.parse(event.data)
        this.dataList.push(obj)
      };
    },
    closeConnection() {
      if (this.source !== null) {
        this.source.close();
      }
      this.source = null;
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.image {
  width: 100%;
  display: block;
}
.button {
  padding: 0;
  float: right;
}
</style>
