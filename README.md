# JameniDialog
项目开发中常用的对话框

        new JameniDialog.Builder(this)
                .setSingleDialogListener(this)
                .setMsg("提示信息1")
                .setTitle("这是标题1")
                .setSingleBtnText("确定1")
                .showSingleDialog();

         new JameniDialog.Builder(this)
                .setNormalDialogListener(this)
                .setMsg("提示信息2")
//                .setTitle("这是标题2")
                .setLeftText("left2")
                .setRightText("right2")
                .showNormalDialog();

        new JameniDialog.Builder(this)
                .setActivity(this)
                .setClickOutSizeCancle(true)
                .setSelectImageListener(this)
                .setDialogCenter(false)
                .showSelectImageDialog();


        new JameniDialog.Builder(this)
                .setActivity(this)
                .setSelectSexListener(this)
                .setClickOutSizeCancle(true)
                .setDialogCenter(false)
                .showSexDialog();

        new JameniDialog.Builder(this)
                .setLoadingText("顶顶顶顶顶顶顶顶顶顶大大大")
                .setClickOutSizeCancle(true)
                .showLoadingDialog();

        List<ItemModel> datalist = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datalist.add(new ItemModel(i + ""));
        }

        new JameniDialog.Builder(this)
                .setActivity(this)
                .setList(datalist)
                .setDialogItemClickListener(this)
                .setClickOutSizeCancle(true)
                .setDialogCenter(false)
                .showList();
















